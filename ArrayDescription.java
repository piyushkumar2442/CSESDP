import java.util.*;

public class ArrayDescription {
    static int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        int[] prev = new int[m + 2]; // previous row
        int[] curr = new int[m + 2]; // current row

        // Base case
        if (a[0] == 0) {
            for (int val = 1; val <= m; val++) {
                prev[val] = 1;
            }
        } else {
            prev[a[0]] = 1;
        }

        // Fill using rolling array
        for (int i = 1; i < n; i++) {
            Arrays.fill(curr, 0); // clear current row

            if (a[i] == 0) {
                for (int val = 1; val <= m; val++) {
                    curr[val] = ((prev[val - 1] + prev[val]) % MOD + prev[val + 1]) % MOD;
                }
            } else {
                int val = a[i];
                curr[val] = ((prev[val - 1] + prev[val]) % MOD + prev[val + 1]) % MOD;
            }

            // move current to previous
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        // Final answer is sum of all valid last values
        int result = 0;
        for (int val = 1; val <= m; val++) {
            result = (result + prev[val]) % MOD;
        }

        System.out.println(result);
    }
}
