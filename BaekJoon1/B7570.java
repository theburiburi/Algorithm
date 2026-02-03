import java.io.*;
import java.util.*;

public class B7570 { //7570 그리??
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[N+1];
        st = new StringTokenizer(br.readLine());
        int ans = 0;
        for(int i=1; i<=N; i++){
            int num = Integer.parseInt(st.nextToken());
            dp[num] = dp[num-1] + 1;
            ans = Math.max(ans, dp[num]);
        }
        System.out.println(N-ans);
    }
}

