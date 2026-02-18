import java.io.*;
import java.util.*;

public class S1861{
    static StringBuilder sb;
    static int N;
    static int[][] arr, dp;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    public static void main(String args[])throws IOException{
        readInput();
        System.out.println(sb);
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            dp = new int[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = 0;
            int maxNum = Integer.MAX_VALUE;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    int count = dfs(i,j);
                    if(ans < count){
                        ans = count;
                        maxNum = arr[i][j];
                    }
                    else if(ans == count){
                        if(arr[i][j] < maxNum){
                            maxNum = arr[i][j];
                        }
                    }
                }
            }
            sb.append("#"+ t + " "+ maxNum + " "+ ans+"\n");
        }
    }

    public static int dfs(int y, int x){
        if(dp[y][x] > 0) return dp[y][x];

        dp[y][x] = 1;
        
        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(0 <= ny && ny < N && 0 <= nx && nx < N){
                if(arr[ny][nx] == arr[y][x] + 1){
                    dp[y][x] = dfs(ny,nx) + 1;
                    break;
                }
            }
        }

        return dp[y][x];
    }
}
