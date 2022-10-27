package secondblock;

import org.jetbrains.annotations.NotNull;

public class Task2 {
    public static int getDifferenceMaxMin(int @NotNull [] numbers) {
        int maxNum = numbers[0];
        int minNum = numbers[0];
        for (int num : numbers) {
            if (num > maxNum) {
                maxNum = num;
            } else if (num < minNum) {
                minNum = num;
            }
        }
        return maxNum - minNum;
    }

    public static void main(String[] args) {
        System.out.println("1. Разница между элементами: " +
                getDifferenceMaxMin(new int[]{10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println("2. Разница между элементами: " +
                getDifferenceMaxMin(new int[]{44, 32, 86, 19}));
    }
}
