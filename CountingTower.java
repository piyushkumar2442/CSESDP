import java.util.*;

public class CountingTower {
    static final int MOD = 1_000_000_007;
    static int MAX = 1_000_001;
    static int[][] dp = new int[MAX][2]; // dp[i][0] and dp[i][1]

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            // Base cases
            dp[n][0] = 1; // 1*2 block at row n
            dp[n][1] = 1; // two 1*1 blocks at row n

            for (int i = n - 1; i >= 0; i--) {
                dp[i][0] = (int)((2L * dp[i + 1][0] + dp[i + 1][1]) % MOD);
                dp[i][1] = (int)((4L * dp[i + 1][1] + dp[i + 1][0]) % MOD);
            }

            // Answer for this test case
            int result = (dp[1][0] + dp[1][1]) % MOD;
            System.out.println(result);
        }
    }
}
