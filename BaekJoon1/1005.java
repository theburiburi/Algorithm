import java.io.*;
import java.util.*;

public class 1005 { // Topological sort
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int time[] = new int[N+1];
            int totalTime[] = new int[N+1];
            List<Integer> list[] = new ArrayList[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                time[i] = Integer.parseInt(st.nextToken());
                list[i] = new ArrayList<>();
            }

            int degree[] = new int[N+1];
            for(int i=1; i<=K; i++) {
                st = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                list[left].add(right);
                degree[right]++;
            }
            int target = Integer.parseInt(br.readLine());

            Queue<Integer> que = new LinkedList<>();
            for(int i=1; i<=N; i++){
                if(degree[i] == 0){
                    que.add(i);
                    totalTime[i] = time[i];
                }
            }

            while(!que.isEmpty()){
                int now = que.poll();
                if(now == target) break;
                for(int next : list[now]){
                    totalTime[next] = Math.max(totalTime[next], totalTime[now] + time[next]);
                    degree[next]--;
                    if(degree[next] == 0) que.add(next);
                }
            }
            sb.append(totalTime[target]+"\n");
        }
        System.out.println(sb);
    }
}
