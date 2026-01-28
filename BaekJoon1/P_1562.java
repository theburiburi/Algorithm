import java.io.*;
import java.util.*;

<<<<<<< HEAD
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
=======
public class P_1562 { // dp, bit masking
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long[][][] dp = new long[N + 1][10][1024];
        long MOD = 1000000000;

        for(int i=1; i<10; i++){
            dp[1][i][1 << i] = 1;
        }

        for(int size = 1; size < N; size++){
            for(int i=0; i<=9; i++){
                for(int j = 0; j<1024; j++){
                    if(dp[size][i][j] == 0) continue;

                    if(i > 0){
                        int next = j | 1 << (i-1);
                        dp[size+1][i-1][next] = (dp[size+1][i-1][next] + dp[size][i][j]) % MOD;
                    }

                    if(i < 9){
                        int next = j | 1 << (i+1);
                        dp[size+1][i+1][next] = (dp[size+1][i+1][next] + dp[size][i][j]) % MOD;
                    }
                }
            }
        }

        long ans = 0;
        for(int i=0; i<=9; i++){
            ans = (ans + dp[N][i][1023]) % MOD;
        }
        System.out.println(ans);
    }
}

>>>>>>> f68673d97fe52b2d4854f4a3c666b835105485a5
