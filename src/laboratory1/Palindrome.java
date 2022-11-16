package laboratory1;

/**
 * Класс, демонстрирующий проверку палиндромов
 */
public class Palindrome {

    /**
     * Возвращает строку, записанную наоборот
     */
    public static String reverseString(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = s.length(); i > 0; --i) {
            result.append(s.charAt(i - 1));
        }
        return result.toString();
    }

    /**
     * Проверяет, является ли строка палиндромом (без учета регистра)
     */
    public static boolean isPalindrome(String s) {
        String lower = s.toLowerCase();
        String rev = reverseString(lower);
        return lower.equals(rev);
    }

    public static void main(String[] args) {
        // java Palindrome.java madam racecar apple kayak song noon
        for (String arg : args) {
            System.out.println("Word \"" + arg + "\" is palindrome: " + isPalindrome(arg));
        }
    }
}
