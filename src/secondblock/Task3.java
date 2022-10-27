package secondblock;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Task3 {
    public static boolean isAvgWhole(int @NotNull [] numbers) {
        int sum = Arrays.stream(numbers).sum();
        return sum % numbers.length == 0;
    }

    public static void main(String[] args) {
        System.out.println("1. Среднее значение является целым числом? " + isAvgWhole(new int[]{1, 3}));
        System.out.println("2. Среднее значение является целым числом? " + isAvgWhole(new int[]{1, 2, 3, 4}));
        System.out.println("3. Среднее значение является целым числом? " + isAvgWhole(new int[]{1, 5, 6}));
        System.out.println("4. Среднее значение является целым числом? " + isAvgWhole(new int[]{1, 1, 1}));
        System.out.println("5. Среднее значение является целым числом? " + isAvgWhole(new int[]{9, 2, 2, 5}));

    }
}
