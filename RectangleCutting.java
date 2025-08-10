import java.util.*;
public class RectangleCutting {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();

        int dp[][]=new int[a+1][b+1];

        for(int i=1;i<=a;i++){
            for(int j=1;j<=b;j++){
               
                if(i==j){
                    dp[i][j]=0;
                }else{
                     int minCut=Integer.MAX_VALUE;
                    //horizontal
                    for(int h=1;h<i;h++){
                        minCut=Math.min(minCut,dp[i-h][j]+dp[h][j]+1);
                    }
                    //vericle
                    for(int v=1;v<j;v++){
                         minCut=Math.min(minCut,dp[i][j-v]+dp[i][v]+1);
                    }

                 dp[i][j]=minCut;
                }
            }
        }
        System.out.println(dp[a][b]);
    }
}
