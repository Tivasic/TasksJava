package firstblock;

public class Task7 {
    public static int getSumNumbers(int a) {
        int sum = 0;
        for (int i = 1; i < a + 1; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("1. Сумма чисел: " + getSumNumbers(3));
        System.out.println("2. Сумма чисел: " + getSumNumbers(10));
        System.out.println("3. Сумма чисел: " + getSumNumbers(7));
    }
}
