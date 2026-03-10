import java.io.*;
import java.util.*;

public class S1251{
    static StringBuilder sb;
    static int N;
    static double E;
    static List<Node> list;
    static int[] arr, xPos, yPos;

    static final long INF = Long.MAX_VALUE;
    public static void main(String args[])throws IOException{
        readInput();
    }
    static class Node{
        int y;
        int x;
        long distance;
        public Node(int y, int x, long distance){
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st1, st2;

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            xPos = new int[N];
            yPos = new int[N];
            list = new ArrayList<>();

            st1 = new StringTokenizer(br.readLine());
            st2 = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                xPos[i] = Integer.parseInt(st1.nextToken());
                yPos[i] = Integer.parseInt(st2.nextToken());
            }
            E = Double.parseDouble(br.readLine());
            sb.append("#").append(t).append(" ");
            solve();
        }
        System.out.println(sb.toString());
    }

    public static void solve(){
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                long xDiff = xPos[i] - xPos[j];
                xDiff = xDiff * xDiff;
                long yDiff = yPos[i] - yPos[j];
                yDiff = yDiff * yDiff;
                list.add(new Node(i,j, xDiff+ yDiff));
            }
        }

        list.sort((s1,s2)-> Long.compare(s1.distance, s2.distance));
        
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = i;
        }

        long ans = 0;
        for(int i=0; i<list.size(); i++){
            Node now = list.get(i);
            int y = now.y;
            int x = now.x;

            if(find(x) != find(y)){
                union(y, x);
                ans+= now.distance;
            }
        }
        sb.append((long)Math.round(ans*E)).append("\n");
    }

    static int find(int x){
        if(x==arr[x]) return x;
        return arr[x] = find(arr[x]);
    }

    static void union(int y, int x){
        y = find(y);
        x = find(x);
        if(x != y){
            arr[y] = x;
        }
    }
}
