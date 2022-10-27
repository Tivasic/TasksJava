package secondblock;

import org.jetbrains.annotations.NotNull;

public class Task8 {
    public static boolean isStrangePair(@NotNull String first, String second) {
        if (first.isEmpty() && second.isEmpty())
            return true;
        if (first.isEmpty() || second.isEmpty())
            return false;
        return first.charAt(0) == second.charAt(second.length() - 1)
                && first.charAt(first.length() - 1) == second.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println("1. Пара является странной? " + isStrangePair("ratio", "orator"));
        System.out.println("2. Пара является странной? " + isStrangePair("sparkling", "groups"));
        System.out.println("3. Пара является странной? " + isStrangePair("bush", "hubris"));
        System.out.println("4. Пара является странной? " + isStrangePair("", ""));
    }
}
