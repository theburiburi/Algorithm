import java.io.*;
import java.util.*;

public class S7733{
    static StringBuilder sb;
    static int N;
    static int[][] cheese;
    public static void main(String args[])throws IOException{
        inputFile();
        System.out.println(sb);
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            cheese = new int[N][N];

            Set<Integer> set = new HashSet<>();
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    cheese[i][j] = Integer.parseInt(st.nextToken());
                    set.add(cheese[i][j]);
                }
            }

            int ans = 0;
            for(int day : set){
                boolean cheeseShape[][] = new boolean[N][N];
                int cnt = 0;
                for(int i=0;i<N;i++){
                    for(int j=0; j<N; j++){
                        if(cheese[i][j] > day && !cheeseShape[i][j]){
                            bfs(day,i,j, cheeseShape);
                            cnt++;
                        }
                    }
                }

                ans = Math.max(ans, cnt);
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
    }

    static void bfs(int day, int y, int x, boolean cheeseShape[][]){
        Queue<int[]> que = new LinkedList<>();
        int dx[] = {0,0,-1,1};
        int dy[] = {1,-1,0,0};

        que.add(new int[]{y,x});
        cheeseShape[y][x] = true;

        while(!que.isEmpty()){
            int now[] = que.poll();
            for(int i=0; i<4; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if(0 > ny || ny >=N || 0>nx || nx >= N) continue;
                if(!cheeseShape[ny][nx] && cheese[ny][nx] > day){
                    cheeseShape[ny][nx] = true;
                    que.add(new int[] {ny,nx});
                }
            }
        }
    }
}
