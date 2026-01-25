import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1912{ //1912 dp
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            dp[i] = Integer.parseInt(st.nextToken());
        }
        int ans = dp[0];
        for(int i=1; i<N; i++){
            dp[i] = Math.max(dp[i], dp[i] + dp[i-1]);
            if(dp[i] > ans) ans = dp[i];
        }
        System.out.println(ans);
    }
}
