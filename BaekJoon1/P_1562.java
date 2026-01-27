import java.io.*;
import java.util.*;

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

