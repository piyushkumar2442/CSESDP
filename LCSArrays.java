import java.util.*;

public class LCSArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        int[] A = new int[n];
        int[] B = new int[m];
        for (int i = 0; i < n; i++) A[i] = sc.nextInt();
        for (int i = 0; i < m; i++) B[i] = sc.nextInt();

        int[][] dp = new int[n + 1][m + 1];

        // Build DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Print LCS length
        System.out.println(dp[n][m]);

        // Recover LCS from DP table (Backtracking)
        List<Integer> lcs = new ArrayList<>();
        int i = n, j = m;

        while (i > 0 && j > 0) {
            if (A[i - 1] == B[j - 1]) {
                lcs.add(A[i - 1]);
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        // Reverse the list to get correct order
        Collections.reverse(lcs);
        for (int num : lcs) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
