import java.io.*;
import java.util.*;

public class B20010{
    static StringBuilder sb;
    static int N, K;
    static int total;
    static List<Node> list[];
    static List<SortNode> sl;
    static int[] arr, values, dp;
    public static void main(String args[])throws IOException{
        inputFile();
    }

    static class SortNode implements Comparable<SortNode>{
        int left;
        int right;
        int value;
        public SortNode(int left, int right, int value){
            this.left = left;
            this.right = right;
            this.value = value;
        }

        @Override
        public int compareTo(SortNode o){
            return value - o.value;
        }
    }

    static class Node{
        int num;
        int value;
        public Node(int num, int value){
            this.num = num;
            this.value = value;
        }
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new List[N];
        arr = new int[N];
        dp = new int[N];

        sl = new ArrayList<>();
        for(int i=0; i<N; i++){
            list[i] = new ArrayList<>();
            arr[i] = i;
        }

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            sl.add(new SortNode(left, right, value));
        }

        Collections.sort(sl);
    }

    static void solve(){
        total = 0;
        for(int i=0; i<K; i++){
            SortNode now = sl.get(i);

            int left = now.left;
            int right = now.right;

            union(left, right, now.value);
        }
        sb.append(total).append("\n");
        int maxMove = 0;
        for(int i=0; i<N; i++){
            if(list[i].size() > 0){
                maxMove = Math.max(maxMove, dfs(i));
            }
        }
        sb.append(maxMove);
    }

    static int dfs(int now){
        if(dp[now] != -1){
            return dp[now];
        }

        int maxNum = 0;
        for(Node next : list[now]){
            maxNum = Math.max(maxNum, dfs(next.num));
        }
        maxNum += list[now].value;

        return dp[now] = maxNum;
    }

    static void union(int x, int y, int value){
        x = find(x);
        y = find(y);
        if(x != y){
            arr[x] = y;
            list[y].add(new Node(x, value));
            total += value;
        }
    }

    static int find(int x){
        if(arr[x] == x){ return x; }
        return arr[x] = find(arr[x]);
    }
}
