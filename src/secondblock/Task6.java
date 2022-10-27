package secondblock;

public class Task6 {
    public static int getFibonacci(int n) {
        int result = 0, first = 0, second = 1;
        for (int i = 0; i < n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("1. Число Фибоначчи: " + getFibonacci(3));
        System.out.println("2. Число Фибоначчи: " + getFibonacci(7));
        System.out.println("3. Число Фибоначчи: " + getFibonacci(12));
    }
}
