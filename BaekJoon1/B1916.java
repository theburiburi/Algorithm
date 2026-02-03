import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1916{//1916 그래???�익?�트??
    static class Node implements Comparable<Node>{
        int endPoint;
        int cost;
        public Node(int endPoint, int cost){
            this.endPoint = endPoint;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node O){
            return cost - O.cost;
        }
    }
    static int N,M;
    static ArrayList<Node> graph[];
    static boolean visited[];
    static int dist[];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];
        for(int i=0; i<=N; i++){
            dist[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int startNum = Integer.parseInt(st.nextToken());
            int endNum = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph[startNum].add(new Node(endNum, cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dikstra(start);
        System.out.println(dist[end]);
    }
    static void dikstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;

        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(!visited[now.endPoint]){
                visited[now.endPoint] = true;

                for(Node next : graph[now.endPoint]){
                    if(!visited[next.endPoint] && dist[next.endPoint] > now.cost + next.cost){
                        dist[next.endPoint] = now.cost + next.cost;
                        pq.add(new Node(next.endPoint, dist[next.endPoint]));
                    }
                }
            }

        }
    }
}
