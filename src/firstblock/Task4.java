package firstblock;

public class Task4 {
    public static boolean isProfitableGamble(double prob, int prize, int pay) {
        return (prob * prize) > pay;
    }

    public static void main(String[] args) {
        System.out.println("1. Выгодна ли игра? " + isProfitableGamble(0.2, 50, 9));
        System.out.println("2. Выгодна ли игра? " + isProfitableGamble(0.9, 1, 2));
        System.out.println("3. Выгодна ли игра? " + isProfitableGamble(0.9, 3, 2));
    }
}
