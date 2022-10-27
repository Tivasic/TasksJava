package secondblock;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Task4 {
    public static @NotNull ArrayList<Integer> getCumulativeSum(int @NotNull [] numbers) {
        var result = new ArrayList<Integer>();
        int sum = 0;
        for (int x : numbers) {
            sum += x;
            result.add(sum);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("1. Массив, в котором каждое целое число является суммой самого себя " +
                "+ всех предыдущих чисел в массиве: " + getCumulativeSum(new int[]{1, 2, 3}));
        System.out.println("2. Массив, в котором каждое целое число является суммой самого себя " +
                "+ всех предыдущих чисел в массиве: " + getCumulativeSum(new int[]{1, -2, 3}));
        System.out.println("3. Массив, в котором каждое целое число является суммой самого себя " +
                "+ всех предыдущих чисел в массиве: " + getCumulativeSum(new int[]{3, 3, -2, 408, 3, 3}));

    }
}
