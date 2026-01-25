import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_2660 { //그래??
    static ArrayList<Integer>[] graph;
    static int[] rank;
    static int N;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        rank = new int[N];
        graph = new ArrayList[N+1];

        for (int i=1; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (a==-1 && b==-1){
                break;
            }

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i=1; i<N+1; i++){
            bfs(i);
        }
        
        int min = Integer.MAX_VALUE;
        for (int i=0; i<N; i++){
            if (rank[i] < min) min = rank[i];
        }

        int count = 0;
        for (int i=0; i<N; i++){
            if (min == rank[i]){
                count++;
                sb2.append((i+1) + " ");
            }
        }
        sb1.append(min + " " + count);

        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[N+1];
        Arrays.fill(visited, false);
        

        q.offer(start);
        visited[start] = true;

        int count = 1;
        int depth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            depth++;
            
            for (int i=0; i<size; i++){
                int now = q.poll();
                for (int current : graph[now]){
                    if (visited[current] == false){
                        q.offer(current);
                        visited[current] = true;
                        count++;
                        if (count == N) break;
                    }
                }
                if (count == N) break;
            }
            if (count == N) break;
        }
        rank[start-1] = depth;
    }
}

