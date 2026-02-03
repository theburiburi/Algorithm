import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class B2252{ //2252 그래??
    static ArrayList<Integer>[] graph;
    static int M, N;
    static int indegree[];
    static StringBuilder sb;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        indegree = new int[N+1];

        for (int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            graph[num1].add(num2);
            indegree[num2]++;
        }

        bfs();
        System.out.println(sb.toString());
    }
    public static void bfs()
    {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i <= N; i++){
            if (indegree[i] == 0) q.offer(i);
        }
        
        while(!q.isEmpty()){
            int now = q.poll();

            sb.append(now + " ");
            for (int next : graph[now]){
                indegree[next]--;
                if(indegree[next] == 0) q.offer(next);
            }
        }
    }
}
