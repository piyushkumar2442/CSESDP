import java.util.*;

public class Gridpath1 {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }

        int[][] dp = new int[n][n];

        // If starting cell is not a trap, initialize it
        if (grid[0][0] != '*') {
            dp[0][0] = 1;
        }

        // Fill the DP table
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    dp[i][j] = 0; // no path through traps
                    continue;
                }

                if (i > 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                }
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                }
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }
}

