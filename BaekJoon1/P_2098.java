import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P_2098 {
    static int N;
    static int W[][];
    static int dp[][];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        for(int i=0;i<N;i++){
            W[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        dp = new int[N][1<<N];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }

        System.out.println(dfs(0,1));

        
    }
    public static int dfs(int now, int visit){
        if(visit == 1 << (N - 1)){
            return W[now][0];
        }

        dp[now][visit] = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            if((visit & 1<<i) == 0 && W[now][i] != 0){
                dp[now][visit] = Math.min(dp[now][visit], dfs(i, visit | 1<<i)+W[now][i]);
            }
        }

        return dp[now][visit];
    }
}
