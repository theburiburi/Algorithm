import java.io.*;
import java.util.*;

public class S3124_2{
    static StringBuilder sb;
    static int V, E;
    static long ans;
    static List<Node> list[];
    public static void main(String args[])throws IOException{
        readInput();
        System.out.println(sb.toString());
    }

    static class Node implements Comparable<Node>{
        int node;
        int value;
        public Node(int node, int value){
            this.node=node;
            this.value=value;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(value, o.value);
        }
    }
    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            
            list = new ArrayList[V+1];
            for(int i=1; i<=V; i++){
                list[i] = new ArrayList<>();
            }

            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                list[left].add(new Node(right, value));
                list[right].add(new Node(left, value));
            }

            solve();
            sb.append(ans).append("\n");
        }
    }
    public static void solve(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[V+1];
        pq.add(new Node(1, 0));
        ans = 0;
        int count = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(visited[now.node]) continue;

            ans += now.value;
            visited[now.node] = true;
            count++;

            if(count == V) break;
            
            for(Node next : list[now.node]){
                if(visited[next.node]) continue;
                pq.add(next);
            }
        }
    }
}
