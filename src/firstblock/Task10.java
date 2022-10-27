package firstblock;

public class Task10 {
    public static boolean getAbcMath(int a, int b, int c) {
        int sum = a;
        for (int i = 0; i < b; i++) {
            sum += sum;
        }
        return sum % c == 0;
    }

    public static void main(String[] args) {
        System.out.println("1. Делится ли сумма? " + getAbcMath(42, 5, 10));
        System.out.println("2. Делится ли сумма? " + getAbcMath(5, 2, 1));
        System.out.println("3. Делится ли сумма? " + getAbcMath(1, 2, 3));
    }
}
