import java.util.*;

public class RemovalGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        long total = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        long[][] dp = new long[n][n];

        for (int l = n - 1; l >= 0; l--) {
            for (int r = l; r < n; r++) {
                if (l == r) {
                    dp[l][r] = arr[l]; // base case: 1 element
                } else {
                    dp[l][r] = Math.max(
                        arr[l] - dp[l + 1][r], // pick left
                        arr[r] - dp[l][r - 1]  // pick right
                    );
                }
            }
        }

        long player1Score = (total + dp[0][n - 1]) / 2;
        System.out.println(player1Score);
    }
}

