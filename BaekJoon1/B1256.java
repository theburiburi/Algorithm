import java.io.*;
import java.util.*;

public class B1256{
    static StringBuilder sb;
    static int N, M, K;
    static int dp[][];
    public static void main(String args[])throws IOException{
        inputFile();
        solve();
        System.out.println(sb.toString().trim());
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    static void solve(){
        dp = new int[N+1][M+1];
        for(int i=0; i<=N; i++){
            for(int j=0; j<=M; j++){
                if(i==0 || j==0){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                    if(dp[i][j] > 1_000_000_000){
                        dp[i][j] = 1_000_000_001;
                    }
                }
            }
        }

        if(dp[N][M] < K) {
            sb.append(-1);
            return;
        }
        else{    
            while(!(N == 0 && M == 0)){
                if(N > 0){
                    int count = dp[N-1][M];
                    if( count >= K){
                        sb.append('a');
                        N--;
                    }
                    else{
                        sb.append('z');
                        K -= count;
                        M--;
                    }
                }
                else{
                    sb.append('z');
                    M--;
                }
            }
        }
    }
}
