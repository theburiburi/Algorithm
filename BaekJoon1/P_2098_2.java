import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P_2098_2 {
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
            Arrays.fill(dp[i], -1);
        }
        
        System.out.println(dfs(0,1));
    }
    public static int dfs(int node, int visit){
        if(visit == ((1<<N)-1)){
            if(arr[node][0] != 0){
                
            }
            return INF;
        } 

        if(dp[node][visit] != -1){

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
        }

        return dp[node][visit];
    }
}
