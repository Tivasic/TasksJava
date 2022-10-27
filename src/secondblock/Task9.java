package secondblock;

import org.jetbrains.annotations.NotNull;

public class Task9 {
    public static boolean isPrefix(@NotNull String word, String prefix) {
        prefix = prefix.replaceAll("-$", "");
        return word.startsWith(prefix);
    }

    public static boolean isSuffix(@NotNull String word, String suffix) {
        suffix = suffix.replaceAll("^-", "");
        return word.endsWith(suffix);
    }

    public static void main(String[] args) {
        System.out.println("1. Префикс входит в слово? " + isPrefix("automation", "auto-"));
        System.out.println("2. Суффикс входит в слово? " + isSuffix("arachnophobia", "-phobia"));
        System.out.println("3. Префикс входит в слово? " + isPrefix("retrospect", "sub-"));
        System.out.println("4. Суффикс входит в слово? " + isSuffix("vocation", "-logy"));
    }
}
