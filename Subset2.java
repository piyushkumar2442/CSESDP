


import java.util.Scanner;

public class Subset2 {
    static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int totalSum = n * (n + 1) / 2;

        // If total sum is odd, we can't split into two equal sets
        if (totalSum % 2 != 0) {
            System.out.println(0);
            return;
        }

        int target = totalSum / 2;

        // dp[i][j] = number of ways to make sum j using first i numbers
        int[][] dp = new int[n + 1][target + 1];

        dp[0][0] = 1; // Base case

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                // Not pick i
                dp[i][j] = dp[i - 1][j];

                // Pick i if possible
                if (j >= i) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - i]) % MOD;
                }
            }
        }

        // Divide by 2 (using modular inverse)
        long result = dp[n][target];
        result = result * inv(2, MOD) % MOD;

        System.out.println(result);
    }

    // Modular inverse using Fermat's Little Theorem
    static long inv(long a, int mod) {
        return pow(a, mod - 2, mod);
    }

    static long pow(long a, long b, int mod) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0)
                res = res * a % mod;
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}

