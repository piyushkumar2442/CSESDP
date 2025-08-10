import java.util.*;

class MoneySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int maxSum = 0;
        for (int el : coins) maxSum += el;

        int[][] dp = new int[n + 1][maxSum + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= maxSum; j++) {
                dp[i][j] = dp[i - 1][j]; // not take
                if (coins[i - 1] <= j && dp[i - 1][j - coins[i - 1]] == 1) {
                    dp[i][j] = 1; // take
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= maxSum; i++) {
            if (dp[n][i] == 1) ans.add(i);
        }

        System.out.println(ans.size());
        for (int x : ans) System.out.print(x + " ");
    }
}
