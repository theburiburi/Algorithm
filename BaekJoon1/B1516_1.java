import java.io.*;
import java.util.*;

public class B1516_1{
    static StringBuilder sb;
    static int[] time, indegree;
    static int[] dp;
    static int N;
    static List<Integer>list[];
    public static void main(String args[])throws IOException{
        inputFile();
        solution();
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        list = new List[N+1];
        time = new int[N+1];
        indegree = new int[N+1];
        dp = new int[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int now = Integer.parseInt(st.nextToken());
                if(now == -1) break;
                list[now].add(i);
                indegree[i]++;
            }
        }
    }

    static void solution(){
        Queue<Integer> que = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            if(indegree[i] == 0) {
                que.add(i);
                dp[i] = time[i];
            }
        }
        
        while(!que.isEmpty()){
            int now = que.poll();
            for(int next : list[now]){
                if(--indegree[next] == 0){
                    que.add(next);
                }
                
                dp[next] = Math.max(dp[now] + time[next], dp[next]); // 
            }
        }

        for(int i=1; i<=N; i++){
            System.out.println(dp[i]);
        }
    }
}