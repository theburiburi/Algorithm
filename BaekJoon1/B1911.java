import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1911{ //민힙 그리??
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        class Node implements Comparable<Node>{
            int start;
            int end;

            public Node(int a, int b){
                this.start = a;
                this.end = b;
            }

            @Override
            public int compareTo(Node other){
                return Integer.compare(this.start, other.start);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pq.offer(new Node(a,b));
        }

        int count = 0;
        int start = 0;
        while(!pq.isEmpty()){
            Node temp = pq.poll();

            if (start < temp.start) start = temp.start;
            int quot = ((int) Math.ceil((double) (temp.end - start) / L));
            start += quot * L;
            count += quot;
        }

        System.out.println(count);
    }
}
