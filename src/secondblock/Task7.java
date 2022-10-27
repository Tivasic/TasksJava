package secondblock;

import org.jetbrains.annotations.NotNull;

public class Task7 {
    public static boolean isValid(@NotNull String code) {
        return code.length() <= 5
                && code.chars().allMatch(Character::isDigit);
    }

    public static void main(String[] args) {
        System.out.println("1. Индекс является действительным? " + isValid("59001"));
        System.out.println("2. Индекс является действительным? " + isValid("853a7"));
        System.out.println("3. Индекс является действительным? " + isValid("732 32"));
        System.out.println("4. Индекс является действительным? " + isValid("393939"));
    }
}
