import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1149{ //1149 dp
    static final int R = 0;
    static final int G = 1;
    static final int B = 2;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int dp[][] = new int[N+1][3];
        for (int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dp[i][R] = Math.min(dp[i-1][G], dp[i-1][B]) + r;
            dp[i][G] = Math.min(dp[i-1][R], dp[i-1][B]) + g;
            dp[i][B] = Math.min(dp[i-1][R], dp[i-1][G]) + b;
        }
        System.out.println(Math.min(dp[N][R], Math.min(dp[N][G], dp[N][B])));
    }
}
