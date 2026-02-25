import java.io.*;
import java.util.*;

public class B1516_2 {
    static int[] time;
    static int[] dp;
    static int N;
    static List<Integer>[] list;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        time = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            dp[i] = -1;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            
            while (true) {
                int pre = Integer.parseInt(st.nextToken());
                if (pre == -1) break;
                list[i].add(pre); 
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(dfs(i)).append("\n");
        }
        
        System.out.print(sb);
    }

    static int dfs(int now) {
        if (dp[now] != -1) {
            return dp[now];
        }

        int maxTime = 0;
        for(int pre : list[now]){
            maxTime = Math.max(maxTime, dfs(pre));
        }

        dp[now] = maxTime + time[now];

        return dp[now];
    }
}