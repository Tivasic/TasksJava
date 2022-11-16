package laboratory2;

import java.util.Scanner;


/**
 * Класс тестирования Point3d
 */
public class Lab1 {
    public static void main(String[] args) {
        Point3d[] points = new Point3d[3];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            double x, y, z;
            System.out.println("Точка №" + (i + 1));
            System.out.print("Координата x: ");
            x = in.nextDouble();
            System.out.print("Координата y: ");
            y = in.nextDouble();
            System.out.print("Координата z: ");
            z = in.nextDouble();
            points[i] = new Point3d(x, y, z);
        }

        if (checkPoints(points[0], points[1], points[2])) {
            System.out.println("Площадь треугольника: " + computeArea(points[0], points[1], points[2]));
        } else {
            System.out.println("Введены две одинаковые точки");
        }
    }

    /**
     * Проверка совпадения точек
     */
    public static boolean checkPoints(Point3d p1, Point3d p2, Point3d p3) {
        return p1.equals(p2) || p1.equals(p3) || p2.equals(p3);
    }

    /**
     * Возвращает площадь треугольника, образованного тремя точками
     */
    public static double computeArea(Point3d p1, Point3d p2, Point3d p3) {
        double side_a = p1.distanceTo(p2);
        double side_b = p1.distanceTo(p3);
        double side_c = p2.distanceTo(p3);
        double semi_p = (side_a + side_b + side_c) / 2;
        return Math.sqrt(semi_p * (semi_p - side_a) * (semi_p - side_b) * (semi_p - side_c));
    }
}