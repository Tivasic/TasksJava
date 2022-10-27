package firstblock;

public class Task2 {
    public static int getSquare(int base, int height) {
        return (base * height) / 2;
    }

    public static void main(String[] args) {
        System.out.println("1. Площадь треугольника: " + getSquare(3, 2));
        System.out.println("2. Площадь треугольника: " + getSquare(7, 4));
        System.out.println("3. Площадь треугольника: " + getSquare(10, 10));
    }
}
