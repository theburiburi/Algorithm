import java.io.*;
import java.util.*;

public class S3289{
    static StringBuilder sb;
    static int n,m;
    static int[] arr;
    public static void main(String args[])throws IOException{
        readInput();
        System.out.println(sb.toString().trim());
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            arr = new int[n+1];
            for(int i=1; i<=n; i++){
                arr[i] = i;
            }
            sb.append("#").append(t).append(" ");
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int type = Integer.parseInt(st.nextToken());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());

                if(type == 0){
                    union(left, right);
                }else{
                    left = find(left);
                    right = find(right);
                    if(left == right) sb.append("1");
                    else sb.append("0");
                }
            }
            sb.append("\n");
        }
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y) {
            arr[y] = x;
        }
    }
    static int find(int x){
        if(x == arr[x]) return x;
        else return arr[x] = find(arr[x]);
    }
}
