import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2533{ //2533 ?¸ë¦¬ ?”í”¼
    static ArrayList<Integer> tree[];
    static int dp[][];
    static boolean visited[];
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        visited = new boolean[N+1];
        dp = new int[N+1][2];

        for(int i=1; i<=N; i++){
            tree[i] = new ArrayList<>();
        }
        for (int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(1);
        System.out.println(Math.min(dp[1][0],dp[1][1]));
    }
    static void dfs(int now){
        visited[now] = true;
        dp[now][1] = 1;
        dp[now][0] = 0;
        for(int child : tree[now]){
            if(!visited[child]) {
                dfs(child);
                dp[now][0] += dp[child][1];
                dp[now][1] += Math.min(dp[child][1], dp[child][0]) ;
            }
        }
    }
    
}
