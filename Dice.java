import java.util.*;

public class Dice {
    static final int mod=(int)1e9+7;
    public static void main(String args[]){
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       long dp[]=new long[n+1];
         dp[0]=1;//base case
        for(int i=1;i<=n;i++){
          for(int dice=1;dice<=6;dice++){
              if(i-dice>=0){
                dp[i]=(dp[i]+dp[i-dice])%mod;
              }
         }
       }
       System.out.println(dp[n]);
        sc.close();
    }
}
