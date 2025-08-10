// import java.util.*;
// public class Cincombination2 {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         int mod=1000000007;
//         int n=sc.nextInt();
//         int x=sc.nextInt();
//         int arr[]=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }

//         int dp[][]=new int[n+1][x+1];
          
//        //base case
//        for(int i=0;i<n;i++){
//           dp[i][0]=1;
//        } 
//        for(int i=n-1;i>=0;i--){
//           for(int sum=1;sum<=x;sum++){
//             int skipping=dp[i+1][sum];
//             int picking=0;
//             if(sum>=arr[i]){
//                 picking=dp[i][sum-arr[i]];
//             }
//             dp[i][sum]=(skipping+picking)%mod;
//           }
         
//        }
//         System.out.println(dp[0][x]);
//     }
// }
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Cincombination2 {
 
    static final int M = 1000000007;
 
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
 
    public static void main(String[] args) {
 
        FastReader input = new FastReader();
        int n = input.nextInt();
        int x = input.nextInt();
 
        int[] a = new int[n];
 
        for (int i = 0; i < a.length; i++) {
            a[i] = input.nextInt();
        }
 
        int[] dp = new int[x + 1];
        dp[0] = 1;
 
        for (int i = 0; i < n; i++) {
            for (int sum = 1; sum <= x; sum++) {
                if (sum - a[i] >= 0){
                    dp[sum] = (dp[sum] + dp[sum - a[i]]) % M;
                }
            }
        }
 
        System.out.println(dp[x]);
 
    }
}