package firstblock;

public class Task3 {
    public static int getSumAnimalsLegs(int chickens, int cows, int pigs) {
        return chickens * 2 + cows * 4 + pigs * 4;
    }

    public static void main(String[] args) {
        System.out.println("1. Сумма ног животных: " + getSumAnimalsLegs(2, 3, 5));
        System.out.println("2. Сумма ног животных: " + getSumAnimalsLegs(1, 2, 3));
        System.out.println("3. Сумма ног животных: " + getSumAnimalsLegs(5, 2, 8));
    }
}
