import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P_2098_2 {
    static int N;
    static int arr[][];
    static int dp[][];
    static final int INF = 16_000_001;
    static int allVisit;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        allVisit = (1<<N)-1;
        for(int i=0;i<N;i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dp = new int[N][1<<N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        System.out.println(tsp(0,1));
    }
    public static int tsp(int node, int visit){
        if(visit == allVisit){
            if(arr[node][0] != 0){
                return arr[node][0];
            }
            return INF;
        } 

        if(dp[node][visit] != -1){
            return dp[node][visit];
        }

        dp[node][visit] = INF;

        for(int i=0; i<N; i++){
            int nextIdx = visit | (1<<i);
            if(arr[node][i] == 0 || nextIdx == visit) continue;

            dp[node][visit] = Math.min(dp[node][visit], tsp(i, nextIdx) + arr[node][i]);
        }

        return dp[node][visit];
    }
}
