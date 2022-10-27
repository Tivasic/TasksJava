package firstblock;

public class Task8 {
    public static int getMaxThirdEdge(int a, int b) {
        /*
         * Должно выполняться условие s1 + s2> s3.
         * Решая относительно s3 получаем s3 <s1 + s2. Поэтому в конце решения отнимаем единицу
         */
        return a + b - 1;
    }

    public static void main(String[] args) {
        System.out.println("1. Максимальное значение 3 ребра: " + getMaxThirdEdge(8, 10));
        System.out.println("2. Максимальное значение 3 ребра: " + getMaxThirdEdge(5, 7));
        System.out.println("3. Максимальное значение 3 ребра: " + getMaxThirdEdge(9, 2));
    }
}
