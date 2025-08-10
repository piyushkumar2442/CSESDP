import java.util.*;

public class EditDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next(); // e.g. LOVE
        String s2 = sc.next(); // e.g. MOVIE

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        // Base cases
        for (int i = 0; i <= n; i++) dp[i][0] = i; // delete
        for (int j = 0; j <= m; j++) dp[0][j] = j; // insert

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]; // no operation
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i-1][j],    // delete
                        Math.min(
                            dp[i][j-1],  // insert
                            dp[i-1][j-1] // replace
                        )
                    );
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}

