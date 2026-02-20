import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class B13334{
    static StringBuilder sb;
    static class Node implements Comparable<Node>{
        int start;
        int end;
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o){
            if(end == o.end) return start - o.start;
            return end - o.end;
        }
    }
    public static void main(String args[])throws IOException{
        readInput();
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Node(Math.min(start, end), Math.max(start, end)));
        }
        
        int L = Integer.parseInt(br.readLine());
        list = list.stream().filter(l -> (l.end-l.start) <= L).collect(Collectors.toList());
        list.sort(null);

        if(list.size() == 0){
            System.out.println(0);
            return;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        for(int i=0; i<list.size(); i++){
            int right = list.get(i).end;
            int left = right-L;
            pq.add(list.get(i).start);
            while(!pq.isEmpty() && pq.peek() < left){
                pq.poll();
            }
            ans = Math.max(ans, pq.size());
        }
        System.out.println(ans);

    }
}
