import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class P_5972{ //그래??5972
    static int N, M;
    static int[] dist;
    static ArrayList<Node>[] Graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N+1];
        visited = new boolean[N+1];

        Graph = new ArrayList[N+1];
        for (int i=0; i<=N; i++)
        {
            Graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;

        for (int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            Graph[A].add(new Node(B, C));
            Graph[B].add(new Node(A, C));
        }
        dijkstra();
        System.out.println(dist[N]);
        br.close();
    }

    public static class Node implements Comparable<Node>
    {
        int loc;
        int cost;
        public Node(int loc, int cost)
        {
            this.loc = loc;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n)
        {
            if (this.cost > n.cost) return 1;
            else return -1;
        }
    }
    
    public static void dijkstra()
    {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,0));

        while(!pq.isEmpty())
        {
            Node current = pq.poll();

            if(visited[current.loc]) continue;
            visited[current.loc] = true;

            for (Node next : Graph[current.loc]){
                if (next.cost + dist[current.loc] < dist[next.loc])
                    dist[next.loc] = next.cost + dist[current.loc];
                if (!visited[next.loc])
                    pq.add(new Node(next.loc, dist[next.loc])); 
            }
        }
    }
}
