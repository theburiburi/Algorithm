import java.io.*;
import java.util.*;

public class Main { //8980 그리디
    static class Node implements Comparable<Node>{
        int start;
        int end;
        int box;
        public Node(int start, int end, int box){
            this.start = start;
            this.end = end;
            this.box = box;
        }
        @Override
        public int compareTo(Node o){
            if(end == o.end) return start - o.start;
            return end - o.end;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        Node node[] = new Node[M];
        int contain[] = new int[N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            node[i] = new Node(n,c,m);
        }
        for(int i=1; i<=N; i++){
            contain[i] = C;
        }

        Arrays.sort(node);
        int ans = 0;
        for(int i=0; i<M; i++){
            Node now = node[i];
            int maxBox = Integer.MAX_VALUE;
            for(int j=now.start; j<now.end; j++){ //최대 적재량 찾기
                maxBox = Math.min(maxBox, contain[j]);
            }
            
            if(now.box <= maxBox){
                for(int j=now.start; j<now.end; j++){
                    contain[j] -= now.box;
                }
                ans += now.box;
            }
            else{
                for(int j=now.start; j<now.end; j++){
                    contain[j] -= maxBox;
                }
                ans += maxBox;
            }
        }
        System.out.println(ans);

    }
}
