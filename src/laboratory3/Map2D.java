package laboratory3;

/**
 * Этот класс представляет собой простую двумерную карту, состоящую из квадратных ячеек.
 * В каждой ячейке указывается стоимость обхода этой ячейки.
 **/
public class Map2D {
    /**
     * Ширина карты.
     **/
    private final int width;

    /**
     * Высота карты.
     **/
    private final int height;

    /**
     * Фактические данные карты, необходимые алгоритму поиска пути для навигации.
     **/
    private final int[][] cells;

    /**
     * Начальное местоположение для выполнения поиска пути A*.
     **/
    private Location start;

    /**
     * Конечное местоположение для выполнения поиска пути A*.
     **/
    private Location finish;


    /**
     * Создает новую 2D-карту с заданными шириной и высотой.
     **/
    public Map2D(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(
                    "width and height must be positive values; got " + width +
                            "x" + height);
        }

        this.width = width;
        this.height = height;

        cells = new int[width][height];

        // Несколько координат для старта и финиша.
        start = new Location(0, height / 2);
        finish = new Location(width - 1, height / 2);
    }


    /**
     * Этот вспомогательный метод проверяет указанные координаты, чтобы увидеть, находятся ли они
     * в пределах границ карты. Если координаты не указаны на карте метод выдает исключение.
     **/
    private void checkCoords(int x, int y) {
        if (x < 0 || x > width) {
            throw new IllegalArgumentException("x must be in range [0, " +
                    width + "), got " + x);
        }

        if (y < 0 || y > height) {
            throw new IllegalArgumentException("y must be in range [0, " +
                    height + "), got " + y);
        }
    }

    /**
     * Возвращает значение true, если указанные координаты содержатся на карте.
     **/
    public boolean contains(int x, int y) {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }


    /**
     * Возвращает значение true, если местоположение содержится в области карты.
     **/
    public boolean contains(Location loc) {
        return contains(loc.xCoord, loc.yCoord);
    }

    /**
     * Возвращает сохраненное значение стоимости для указанной ячейки.
     **/
    public int getCellValue(int x, int y) {
        checkCoords(x, y);
        return cells[x][y];
    }

    /**
     * Возвращает сохраненное значение стоимости для указанной ячейки.
     **/
    public int getCellValue(Location loc) {
        return getCellValue(loc.xCoord, loc.yCoord);
    }

    /**
     * Задает значение стоимости для указанной ячейки.
     **/
    public void setCellValue(int x, int y, int value) {
        checkCoords(x, y);
        cells[x][y] = value;
    }

    /**
     * Возвращает начальное местоположение для карты, где сгенерированный путь начнется с start.
     **/
    public Location getStart() {
        return start;
    }

    /**
     * Задает начальное местоположение для карты.
     * Здесь находится сгенерированный путь, который начнется с start
     **/
    public void setStart(Location loc) {
        if (loc == null)
            throw new NullPointerException("loc cannot be null");

        start = loc;
    }

    /**
     * Возвращает конечное местоположение для карты, где сгенерированный путь завершится finish.
     **/
    public Location getFinish() {
        return finish;
    }

    /**
     * Задает конечное местоположение для карты.
     * Здесь находится сгенерированный путь, который завершится finish.
     **/
    public void setFinish(Location loc) {
        if (loc == null)
            throw new NullPointerException("loc cannot be null");

        finish = loc;
    }
}
