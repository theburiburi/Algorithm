import java.io.*;
import java.util.*;

public class S_12712 {
    static int answer = 0;
    static int arr[][];

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim());
        
        for(int t=1; t<=T; t++){
            
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            arr = new int[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            answer = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    findMax(i,j, N, M);
                }
            }
            sb.append("#"+t+" ").append(answer+"\n");
            
        }
        System.out.println(sb);
    }
    public static void findMax(int y, int x, int n, int m){
        // + 모양 분사
        int plusSum = arr[y][x];
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        for(int d=0; d<4; d++){
            for(int i=1; i<m; i++){
                int ny = y + dy[d] * i;
                int nx = x + dx[d] * i;
                if(possible(ny, nx, n)) plusSum += arr[ny][nx];
            }
        }
        answer = Math.max(answer, plusSum);

        // x 모양 분사
        int xSum = arr[y][x];
        int[] ddy = {-1, -1, 1, 1};
        int[] ddx = {-1, 1, -1, 1};

        for(int d=0; d<4; d++){
            for(int i=1; i<m; i++){
                int ny = y + ddy[d] * i;
                int nx = x + ddx[d] * i;
                if(possible(ny, nx, n)) xSum += arr[ny][nx];
            }
        }
        answer = Math.max(answer, xSum);
    }
    public static boolean possible(int i, int j, int n){
        return i >= 0 && i < n && j >= 0 && j < n;
    }
}

