import java.io.*;
import java.util.*;

public class S2806{
    static StringBuilder sb;
    static Node queen[];
    static int ans, N;
    public static void main(String args[])throws IOException{
        readInput();
        System.out.println(sb);
    }

    public static class Node{
        int y;
        int x;
        public Node(int y, int x){
            this.y= y;
            this.x= x;
        }
    }
    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            ans = 0;
            N = Integer.parseInt(br.readLine());
            sb.append("#"+t+ " ");

            if(N==1) {
                sb.append(1+"\n");
                continue;
            }

            queen = new Node[N];

            int count = 0;
            dfs(1, 1, count);
            sb.append(ans+"\n");
        }
    }

    public static void dfs(int y, int x, int count){
        if(count == N){
            ans++;
            return;
        }

        for(int i = y; i<=N; i++){
            for(int j = x; j<=N; j++){
                    if(check(i,j,count)){
                        queen[count] = new Node(i, j);
                        dfs(i+1, 1, count+1); // 횟수 줄이기
                    }
            }
        }
    }
    public static boolean check(int y, int x, int count){
        for(int i=0; i<count; i++){
            int qY = queen[i].y;
            int qX = queen[i].x;

            int diffY = Math.abs(qY - y); 
            int diffX = Math.abs(qX - x);
            if(qY == y || qX == x || diffX == diffY){
                return false;
            }
        }
        return true;
    }
}
