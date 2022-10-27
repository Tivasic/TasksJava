package firstblock;

import org.jetbrains.annotations.NotNull;

public class Task9 {
    public static int getSumCubes(int @NotNull [] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += (int) Math.pow(num, 3);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("1. Сумма кубов последовательности: " + getSumCubes(new int[]{1, 5, 9}));
        System.out.println("2. Сумма кубов последовательности: " + getSumCubes(new int[]{3, 4, 5}));
        System.out.println("3. Сумма кубов последовательности: " + getSumCubes(new int[]{2}));
        System.out.println("4. Сумма кубов последовательности: " + getSumCubes(new int[]{}));

    }
}
