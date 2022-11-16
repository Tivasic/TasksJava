package laboratory3;

/**
 * Этот класс представляет определенное местоположение на 2D-карте. Координаты являются целочисленными значениями.
 **/
public class Location {
    /**
     * Координата X.
     **/
    public int xCoord;

    /**
     * Координата Y
     **/
    public int yCoord;


    /**
     * Создает новое местоположение с указанными целочисленными координатами.
     **/
    public Location(int x, int y) {
        xCoord = x;
        yCoord = y;
    }


    /**
     * Указывает, равен ли объект O этому.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Location location = (Location) o;

        if (xCoord != location.xCoord)
            return false;
        return yCoord == location.yCoord;
    }

    /**
     * Возвращает значение хэш-кода для этого объекта.
     */
    @Override
    public int hashCode() {
        int result = 7;
        result = 31 * result + xCoord;
        result = 31 * result + yCoord;
        return result;
    }
}
