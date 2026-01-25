import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;

public class P_1238{ //1238 그래??
    static int N, M, X;

    static ArrayList<Node>[] goX;
    static ArrayList<Node>[] backX;
    
    static int dist[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        goX = new ArrayList[N+1];
        backX = new ArrayList[N+1];

        for (int i=1; i<=N; i++){
            goX[i] = new ArrayList<>();
            backX[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            goX[from].add(new Node(to, cost));
            backX[to].add(new Node(from, cost));
        }

        int maxTime = 0;
        int go[] = dijkstra(goX);
        int back[] = dijkstra(backX);
        for (int i=1; i<=N; i++)
        {
            int temp = go[i] + back[i];
            maxTime = temp > maxTime ? temp : maxTime;
        }
        System.out.println(maxTime);
    }

    public static class Node implements Comparable<Node>{
        int loc;
        int cost;
        public Node(int loc, int cost){
            this.loc = loc;
            this.cost = cost;
        }
        @Override
        public int compareTo(Main.Node o) {
            return this.cost - o.cost;
        }
    }

    public static int[] dijkstra(ArrayList<Node>[] Graph){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[N+1];
        int[] dp = new int[N+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[X] = 0;
        pq.offer(new Node(X, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if (visited[now.loc]) continue;
            visited[now.loc] = true;

            for (Node Next : Graph[now.loc]){
                if (dp[now.loc] + Next.cost < dp[Next.loc]){
                    dp[Next.loc] = dp[now.loc] + Next.cost;
                    pq.add(new Node(Next.loc, dp[Next.loc]));
                }
            }
        }
        return dp;
    }
}
