import java.io.*;
import java.util.*;

public class 13904 { //13904 그리디
    static class Node implements Comparable<Node>{
        int d;
        int w;
        public Node(int d, int w){
            this.d = d;
            this.w = w;
        }
        @Override
        public int compareTo(Node o){
            return d - o.d;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new Node(d, w));
        }
        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Node temp : list){
            pq.add(temp.w);
            while(pq.size() > temp.d){
                pq.poll();
            }
        }
        int sol = 0;
        while(!pq.isEmpty()){
            sol += pq.poll();
        }
        System.out.println(sol);
    }
}
