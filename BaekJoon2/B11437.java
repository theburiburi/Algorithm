import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11437{//?�리 , 공통조상?�드
    static int N, M;
    static ArrayList<Integer> graph[];
    static boolean visited[];
    static int depth[];
    static int parent[];
    static StringBuilder sb;
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        depth = new int[N+1];
        parent = new int[N+1];

        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
            graph[a].add(b);
        }
        M = Integer.parseInt(br.readLine());
        dfs(1, 1);
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            solution(a, b);
        }

        System.out.println(sb.toString());
    }
    static void dfs(int now, int dep){
        visited[now] = true;
        depth[now] = dep;
        for (int next: graph[now]){
            if(!visited[next]){
                parent[next] = now;
                dfs(next, dep+1);
            }
        }
    }
    static void solution(int a, int b){
        int ADepth = depth[a];
        int BDepth = depth[b];

        while(ADepth > BDepth){
            ADepth--;
            a = parent[a];
        }
        while(ADepth < BDepth){
            BDepth--;
            b = parent[b];
        }
        while(a != b){
            a = parent[a];
            b = parent[b];
        }
        sb.append(a).append("\n");
    }
}
