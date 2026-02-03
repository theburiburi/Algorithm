import java.io.*;
import java.util.*;

public class B2098_1 {
    static int ans = Integer.MAX_VALUE;
    static int N;
    static int arr[][];
    static int dp[][];
    static final int INF = 16_000_001;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0;i<N;i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dp = new int[N][1<<N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][1] = 0;
        dfs(0,1);
        System.out.println(ans);
    }
    public static void dfs(int node, int visit){
        if(visit == ((1<<N)-1)){
            if(arr[node][0] != 0){
                ans = Math.min(ans, dp[node][visit] + arr[node][0]);
            }
            return;
        } 

        for(int i=0; i<N; i++){
            if (node == i) continue;
            int nextIdx = visit | (1<<i);

            if(nextIdx != visit){ 
                if(arr[node][i] > 0 && dp[i][nextIdx] > dp[node][visit] + arr[node][i]){
                    dp[i][nextIdx] = dp[node][visit] + arr[node][i];
                    dfs(i, nextIdx);
                }
            }
        } // dfs가 좀 잘 안 돌아가긴 하는 듯 ,,,
    }
}
