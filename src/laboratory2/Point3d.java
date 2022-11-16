package laboratory2;


/**
 * Класс трехмерной точки
 */
public class Point3d {
    /**
     * координата X
     */
    private double xCoord;
    /**
     * координата Y
     */
    private double yCoord;
    /**
     * координата Z
     */
    private double zCoord;

    /**
     * Конструктор инициализации
     */
    public Point3d(double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    /**
     * Конструктор по умолчанию.
     */
    public Point3d() {
        this(0, 0, 0);
    }

    /**
     * Возвращение координаты X
     */
    public double getX() {
        return xCoord;
    }

    /**
     * Установка значения координаты X.
     */
    public void setX(double x) {
        xCoord = x;
    }

    /**
     * Возвращение координаты Y
     */
    public double getY() {
        return yCoord;
    }

    /**
     * Установка значения координаты Y.
     */
    public void setY(double y) {
        yCoord = y;
    }

    /**
     * Возвращение координаты Z
     */
    public double getZ() {
        return zCoord;
    }

    /**
     * Установка значения координаты Z.
     */
    public void setZ(double z) {
        zCoord = z;
    }

    /**
     * Возвращает расстояние от текущей точки до точки other
     * с точностью до двух знаков после запятой.
     **/
    public double distanceTo(Point3d other) {
        double dist = Math.sqrt(
                Math.pow(xCoord - other.xCoord, 2)
                        + Math.pow(yCoord - other.yCoord, 2)
                        + Math.pow(zCoord - other.zCoord, 2));
        return Math.round(dist * 100) / 100.;
    }

    /**
     * Сравнение значений на равенство.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Point3d point3d = (Point3d) o;
        return Double.compare(xCoord, point3d.xCoord) == 0
                && Double.compare(yCoord, point3d.yCoord) == 0
                && Double.compare(zCoord, point3d.zCoord) == 0;
    }
}
