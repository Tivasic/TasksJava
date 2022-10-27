package secondblock;

import org.jetbrains.annotations.NotNull;

public class Task1 {
    public static @NotNull String makeModifyString(@NotNull String word, int n) {
        StringBuilder result = new StringBuilder();
        for (char ch : word.toCharArray()) {
            result.append(String.valueOf(ch).repeat(n));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("1. Слово изменено: " + makeModifyString("mice", 5));
        System.out.println("2. Слово изменено: " + makeModifyString("hello", 3));
        System.out.println("3. Слово изменено: " + makeModifyString("stop", 1));
    }
}
