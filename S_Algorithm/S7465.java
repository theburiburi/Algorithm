import java.io.*;
import java.util.*;

public class S7465{
    static StringBuilder sb;
    static int arr[];
    static int N, M;
    public static void main(String args[])throws IOException{
        readInput();
        System.out.println(sb.toString());
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N+1];
            for(int i=1; i<=N; i++){
                arr[i] = i;
            }
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());

                union(left, right);
            }
            Set<Integer> set = new HashSet<>();
            for(int i=1; i<=N; i++){
                set.add(find(i));
            }
            sb.append("#").append(t).append(" ").append(set.size()).append("\n");
        }
    }

    public static int find(int x){
        if(x == arr[x]) return x;
        else return arr[x] = find(arr[x]);
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            arr[y] = x;
        }
    }   
}
