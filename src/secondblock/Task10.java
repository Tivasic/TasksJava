package secondblock;

import org.jetbrains.annotations.NotNull;

public class Task10 {
    public static @NotNull String hexLattice(int number) {
        float N_float = (float) ((3 + Math.sqrt(12 * number - 3)) / 6);
        int N = (int) N_float;
        if (Math.abs(N_float - N) > 0)
            return "Invalid";

        StringBuilder result = new StringBuilder();
        int n_lines = 2 * N - 1;
        for (int i = 0; i < N; ++i) {
            result.append(" ".repeat(N - i - 1));
            result.append(" o".repeat(Math.max(0, N + i)));
            result.append(" ".repeat(N - i));
            result.append("\n");
        }
        for (int i = N; i < n_lines; ++i) {
            result.append(" ".repeat(Math.max(0, i - N + 1)));
            result.append(" o".repeat(Math.max(0, n_lines - i + N - 1)));
            result.append(" ".repeat(Math.max(0, i - N + 2)));
            result.append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("1.hexLattice(1)\n" + hexLattice(1));
        System.out.println("2. hexLattice(7)\n" + hexLattice(7));
        System.out.println("3. hexLattice(19)\n" + hexLattice(19));
        System.out.println("4. hexLattice(21)\n" + hexLattice(21));
    }
}
