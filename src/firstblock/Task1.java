package firstblock;

public class Task1 {
    public static int getRemains(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            System.out.println("Деление на 0 невозможно!");
            return 0;
        }
        return num1 % num2;
    }

    public static void main(String[] args) {
        System.out.println("1. Остаток от деления чисел: " + getRemains(1, 3));
        System.out.println("2. Остаток от деления чисел: " + getRemains(3, 4));
        System.out.println("3. Остаток от деления чисел: " + getRemains(-9, 45));
        System.out.println("4. Остаток от деления чисел: " + getRemains(5, 5));
    }
}
