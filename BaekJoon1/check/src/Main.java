import java.io.*;
import java.util.*;

public class Main { //19700 해시
    static Map<Integer, Integer> map = new HashMap<>();
    static Node list[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        list = new Node[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            list[i] = new Node(h,k);
        }
        Arrays.sort(list);

        TreeSet<Integer> ts = new TreeSet<>();
        int group[] = new int[N+1];
        group[0] = N;
        for(Node now : list){
            Integer find = ts.lower(now.k);
            find = find == null ? 0 : find;
            if(--group[find] == 0){
                ts.remove(find);
            }
            group[find+1]++;
            ts.add(find+1);
        }

        int ans = 0;
        for(int i=1; i<=N; i++){
            ans += group[i];
        }
        System.out.println(ans);

    }
    static class Node implements Comparable<Node>{
        int h;
        int k;
        public Node(int h, int k){
            this.h = h;
            this.k = k;
        }
        @Override
        public int compareTo(Node o){
            return o.h - h;
        }
    }
}