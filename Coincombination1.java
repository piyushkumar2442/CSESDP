
import java.util.Scanner;

public class Coincombination1 {

    static final int M = 1000000007;
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // 3
        int x = input.nextInt(); // 9

        int[] coins = new int[n]; // 2 3 5

        for (int i = 0; i < n; i++) {
            coins[i] = input.nextInt();
        }

        int[] dp = new int[x + 1];

        dp[0] = 1; // Base Case

        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= coins[j]) {
                    dp[i] = (dp[i] + dp[i - coins[j]]) % M;
                }
            }
        }

        System.out.println(dp[x]);

        input.close();
    }
}