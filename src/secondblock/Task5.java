package secondblock;

import org.jetbrains.annotations.NotNull;

public class Task5 {
    public static int getDecimal(@NotNull String number) {
        String[] splitter = number.split("\\.");
        if (splitter.length == 1) {
            return 0;
        }
        return splitter[1].length();
    }

    public static void main(String[] args) {
        System.out.println("1. Число десятичных знаков: " + getDecimal("43.20"));
        System.out.println("2. Число десятичных знаков: " + getDecimal("400"));
        System.out.println("3. Число десятичных знаков: " + getDecimal("3.1"));
    }
}
