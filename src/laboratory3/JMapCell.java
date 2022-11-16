package laboratory3;

import javax.swing.*;
import java.awt.*;


/**
 * Этот класс является пользовательским компонентом Swing для представления одной ячейки на 2D-карте.
 * Ячейка имеет несколько различных видов состояния, но самое основное состояние - это то,
 * является ли ячейка проходимой или нет.
 */
public class JMapCell extends JComponent {
    private static final Dimension CELL_SIZE = new Dimension(12, 12);

    /**
     * Значение True указывает, что ячейка является конечной точкой, либо начальной.
     **/
    boolean endpoint = false;


    /**
     * Значение True указывает на то, что ячейка проходима; значение false означает, что это не так.
     **/
    boolean passable = true;

    /**
     * Значение True указывает, что эта ячейка является частью пути между началом и концом.
     **/
    boolean path = false;

    /**
     * Создает новую ячейку карты с указанной "возможностью". Ввод значения
     * true означает, что ячейка проходима
     **/
    public JMapCell(boolean pass) {
        // Устанавливает предпочтительный размер ячейки, чтобы управлять начальным размером окна.
        setPreferredSize(CELL_SIZE);

        setPassable(pass);
    }

    /**
     * Создает новую ячейку карты, которая по умолчанию доступна для прохождения.
     **/
    public JMapCell() {
        // Вызовите конструктор, указав значение true для "passable".
        this(true);
    }

    /**
     * Помечает эту ячейку либо как начальную, либо как конечную ячейку.
     **/
    public void setEndpoint(boolean end) {
        endpoint = end;
        updateAppearance();
    }

    /**
     * Устанавливает, что эта ячейка является проходимой или непроходимой.
     **/
    public void setPassable(boolean pass) {
        passable = pass;
        updateAppearance();
    }

    /**
     * Возвращает значение true, если эта ячейка проходима, или значение false в противном случае.
     **/
    public boolean isPassable() {
        return passable;
    }

    /**
     * Помечает эту ячейку как часть пути, обнаруженного алгоритмом A*.
     **/
    public void setPath(boolean path) {
        this.path = path;
        updateAppearance();
    }

    /**
     * Этот вспомогательный метод обновляет цвет фона, чтобы он соответствовал текущему
     * внутреннее состояние ячейки.
     **/
    private void updateAppearance() {
        if (passable) {
            // Проходимая клетка. Указываем ее состояние с помощью границы.
            setBackground(Color.WHITE);

            if (endpoint)
                setBackground(Color.CYAN);
            else if (path)
                setBackground(Color.GREEN);
        } else {
            // Непроходимая ячейка. Окрашиваем в красный
            setBackground(Color.RED);
        }
    }

    /**
     * Реализация метода paint для рисования цвета фона в ячейках карты.
     **/
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
