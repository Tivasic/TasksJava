package laboratory3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * Простое приложение Swing для демонстрации алгоритма поиска пути A*.
 * Пользователю предоставляется карта, содержащая начальное и конечное местоположение. Пользователь
 * может рисовать или устранять препятствия на карте, а затем нажимать кнопку для вычисления
 * путь от начала до конца с использованием алгоритма поиска пути A*. Если путь
 * найден, он отображается зеленым цветом.
 **/
public class AStarApp {

    /**
     * Количество ячеек сетки в направлении X.
     **/
    private final int width;

    /**
     * Количество ячеек сетки в направлении Y.
     **/
    private final int height;

    /**
     * Точка с которой начинается путь.
     **/
    private final Location startLoc;

    /**
     * Точка с которой заканчивается путь.
     **/
    private final Location finishLoc;

    /**
     * Это 2D массив компонентов пользовательского интерфейса, которые обеспечивают отображение и манипулирование
     * из ячеек на карте.
     ***/
    private JMapCell[][] mapCells;


    /**
     * Этот внутренний класс обрабатывает события мыши в основной сетке ячеек карты,
     * изменяя ячейки на основе состояния кнопки мыши и начального редактирования.
     **/
    private static class MapCellHandler implements MouseListener {
        /**
         * Это значение будет истинным, если была нажата кнопка мыши, и мы
         * в данный момент находимся в процессе операции модификации.
         **/
        private boolean modifying;

        /**
         * Это значение записывает, делаем ли мы ячейки проходимыми или
         * непроходимый. Что это такое, зависит от исходного состояния ячейки.
         **/
        private boolean makePassable;

        /**
         * Инициирует операцию модификации.
         **/
        public void mousePressed(MouseEvent e) {
            modifying = true;

            JMapCell cell = (JMapCell) e.getSource();

            // Если текущая ячейка проходима, то мы делаем ее
            // непроходимой; если она непроходима, то делаем ее проходимой.

            makePassable = !cell.isPassable();

            cell.setPassable(makePassable);
        }

        /**
         * Завершает операцию модификации.
         **/
        public void mouseReleased(MouseEvent e) {
            modifying = false;
        }

        /**
         * Если мышь была нажата, это продолжает модификацию
         * операции в новой ячейке.
         **/
        public void mouseEntered(MouseEvent e) {
            if (modifying) {
                JMapCell cell = (JMapCell) e.getSource();
                cell.setPassable(makePassable);
            }
        }

        /**
         * Не требуется для этого обработчика.
         **/
        public void mouseExited(MouseEvent e) {
            // Это игнорируем.
        }

        /**
         * Не требуется для этого обработчика.
         **/
        public void mouseClicked(MouseEvent e) {
            // Это игнорируем.
        }
    }


    /**
     * Создает новый экземпляр AStarApp с указанной шириной карты и высотой.
     **/
    public AStarApp(int w, int h) {
        if (w <= 0)
            throw new IllegalArgumentException("w must be > 0; got " + w);

        if (h <= 0)
            throw new IllegalArgumentException("h must be > 0; got " + h);

        width = w;
        height = h;

        startLoc = new Location(2, h / 2);
        finishLoc = new Location(w - 3, h / 2);
    }


    /**
     * Простой вспомогательный метод для настройки пользовательского интерфейса Swing. Вызывается
     * из потока обработчика событий Swing, чтобы быть потоко-безопасным.
     **/
    private void initGUI() {
        JFrame frame = new JFrame("Pathfinder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();

        contentPane.setLayout(new BorderLayout());

        // Используя GridBagLayout, потому что он действительно учитывает предпочтительный размер
        // компонентов, которые он содержит.

        GridBagLayout gbLayout = new GridBagLayout();
        GridBagConstraints gbConstraints = new GridBagConstraints();
        gbConstraints.fill = GridBagConstraints.BOTH;
        gbConstraints.weightx = 1;
        gbConstraints.weighty = 1;
        gbConstraints.insets.set(0, 0, 1, 1);

        JPanel mapPanel = new JPanel(gbLayout);
        mapPanel.setBackground(Color.GRAY);

        mapCells = new JMapCell[width][height];

        MapCellHandler cellHandler = new MapCellHandler();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                mapCells[x][y] = new JMapCell();

                gbConstraints.gridx = x;
                gbConstraints.gridy = y;

                gbLayout.setConstraints(mapCells[x][y], gbConstraints);

                mapPanel.add(mapCells[x][y]);
                mapCells[x][y].addMouseListener(cellHandler);
            }
        }

        contentPane.add(mapPanel, BorderLayout.CENTER);

        JButton findPathButton = new JButton("Find Path");
        findPathButton.addActionListener(e -> findAndShowPath());

        contentPane.add(findPathButton, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);

        mapCells[startLoc.xCoord][startLoc.yCoord].setEndpoint(true);
        mapCells[finishLoc.xCoord][finishLoc.yCoord].setEndpoint(true);
    }


    /**
     * Запускает приложение. Вызывается из метода main.
     **/
    private void start() {
        SwingUtilities.invokeLater(this::initGUI);
    }


    /**
     * Этот вспомогательный метод пытается вычислить путь, используя текущую карту состояния.
     * Создается новый объект Map 2D и инициализируется из текущего состояния приложения.
     * Затем А* вызывает навигатор, и если путь найден, дисплей обновляется и показывает найденный путь.
     **/
    private void findAndShowPath() {
        // Создание 2D-объект карты, содержащий текущее состояние пользовательского ввода.

        Map2D map = new Map2D(width, height);
        map.setStart(startLoc);
        map.setFinish(finishLoc);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                mapCells[x][y].setPath(false);

                if (mapCells[x][y].isPassable())
                    map.setCellValue(x, y, 0);
                else
                    map.setCellValue(x, y, Integer.MAX_VALUE);
            }
        }

        // Вычисляем путь

        Waypoint wp = AStarPathfinder.computePath(map);

        while (wp != null) {
            Location loc = wp.getLocation();
            mapCells[loc.xCoord][loc.yCoord].setPath(true);

            wp = wp.getPrevious();
        }
    }


    /**
     * Точка входа для приложения.
     **/
    public static void main(String[] args) {
        AStarApp app = new AStarApp(40, 30);
        app.start();
    }
}
