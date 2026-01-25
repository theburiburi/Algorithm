import java.io.*;
import java.util.*;


public class P_1949 { //1949 dp ?¸ë¦¬
    static List<Integer> list[];
    static int arr[];
    static int dp[][];
    static boolean visited[];
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        list = new ArrayList[N+1];
        dp = new int[N+1][2];
        visited = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            list[left].add(right);
            list[right].add(left);
        }

        dfs(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    public static void dfs(int now){
        dp[now][0] = 0;
        dp[now][1] = arr[now];
        visited[now] = true;

        for(int next : list[now]){
            if(!visited[next]){
                dfs(next);

                dp[now][0] += Math.max(dp[next][0], dp[next][1]);
                dp[now][1] += dp[next][0];
            }            
        }
    }
}


