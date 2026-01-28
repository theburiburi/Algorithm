import java.io.*;
import java.util.*;

public class P_1562 {
    static int divideNum = 1000000000;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int dp[][] = new int[N+1][10];
        dp[10][0] = 1;
        dp[11][0] = 1;
        dp[11][9] = 1;
        dp[11][1] = 1;
        for(int i=12; i<=N; i++){
            for(int j=0; j<10; j++){
                if (j==0) dp[i][j] = dp[i-1][1];
                else if (j==9) dp[i][j] = dp[i-114][8];
                else{
                    dp[i][j] += dp[i-1][j-1] + dp[i-1][j+1];
                    dp[i][j] += dp[i-2][j] * (i-2)*2 + 2;
                }
            }
        }
        int answer = 0;
        for(int i=0; i<10; i++){
            answer += dp[N][i];
        }
        System.out.println(answer);
    }    
}
