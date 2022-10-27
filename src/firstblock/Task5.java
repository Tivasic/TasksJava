package firstblock;

import org.jetbrains.annotations.NotNull;

public class Task5 {
    public static @NotNull String getOperation(int a, int b, int n) {
        if (a + b == n) {
            return "Add";
        } else if (a - b == n || b - a == n) {
            return "Sub";
        } else if (a / b == n || b / a == n) {
            return "Div";
        } else if (a * b == n) {
            return "Mul";
        }
        return "None";
    }

    public static void main(String[] args) {
        System.out.println("1. Необходимо выполнить: " + getOperation(24, 15, 9));
        System.out.println("2. Необходимо выполнить: " + getOperation(24, 26, 2));
        System.out.println("3. Необходимо выполнить: " + getOperation(15, 11, 11));
    }
}
