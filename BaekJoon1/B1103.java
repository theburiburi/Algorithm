import java.io.*;
import java.util.*;

public class B1103{
    static int N, M, ans;
    static boolean cycled;

    static char[][] arr;
    static int[][] dp;
    static boolean[][] visited;

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
    public static void main(String args[])throws IOException{
        inputFile();
        ans = dfs(0,0);
        if(cycled) System.out.println(-1);
        else{
            System.out.println(ans);
        }
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = 0;

        arr = new char[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine().toCharArray();
        }
    }


    static int dfs(int y, int x){
        if(visited[y][x]){
            cycled = true;
            return -1;
        }
        
        if(dp[y][x] != 0) return dp[y][x];

        visited[y][x] = true;
        int move = arr[y][x] - '0';
        int maxMove = 1;

        for(int i=0;i<4;i++){
            int ny = y + dy[i] * move;
            int nx = x + dx[i] * move;

            if(0> ny || ny >= N || 0>nx || nx >=M || arr[ny][nx] == 'H'){
                continue;
            }

            int next = dfs(ny, nx);
            if(cycled) return 0;

            if(next+1 > maxMove){
                maxMove = next+1;
            }
        }

         visited[y][x] = false;
         return dp[y][x] = maxMove;
    }
}
