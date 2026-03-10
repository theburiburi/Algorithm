import java.io.*;
import java.util.*;

public class S3124{
    static StringBuilder sb;
    static int V, E, ans;
    static int[] arr;
    static List<Node> list;
    public static void main(String args[])throws IOException{
        readInput();
        System.out.println(sb.toString());
    }

    static class Node{
        int left;
        int right;
        int value;
        public Node(int left, int right, int value){
            this.left=left;
            this.right=right;
            this.value=value;
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
            
            list = new ArrayList<>();
            arr = new int[V+1];

            for(int i=1; i<=V; i++){
                arr[i] = i;
            }

            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                list.add(new Node(left, right, value));
            }

            list.sort((s1,s2) -> Integer.compare(s1.value, s2.value));
            solve();
            sb.append(ans).append("\n");
        }
    }
    public static void solve(){
        ans = 0;
        for(Node now : list){
            int y = now.left;
            int x = now.right;
            if(find(y) != find(x)){
                union(y, x);
                ans += now.value;
            }
        }
    }
    public static int find(int x){
        if(x == arr[x]) return x;
        return arr[x] = find(arr[x]);
    }

    public static void union(int y, int x){
        y = find(y);
        x = find(x);
        if(y != x){
            arr[y] = x;
        }
    }
}
