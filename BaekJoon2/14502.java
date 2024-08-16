import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main{ //14502 그리디
    static int[][] arr;
    static int[][] copyMap;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int maxCount;
    static int N, M;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0);
        System.out.println(maxCount);
    }
    static class virus{
        int y;
        int x;
        public virus(int i, int j){
            y = i;
            x = j;
        }
    }

    public static void dfs(int wallCount){
        if (wallCount == 3){
            bfs();
            return;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if (arr[i][j] == 0){
                    arr[i][j] = 1;
                    dfs(wallCount+1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void bfs(){
        Queue<virus> queue = new LinkedList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 2){
                    queue.add(new virus(i, j));
                }
            }
        }


        copyMap = new int[N][M];
        for(int i=0; i<N; i++){
            copyMap[i] = arr[i].clone();
        }

        while(!queue.isEmpty()){
            virus temp = queue.poll();

            for (int i=0; i<4; i++){
                int xx = temp.x + dx[i];
                int yy = temp.y + dy[i];
                if(0 <= xx && xx < M && 0 <= yy && yy < N){
                    if(copyMap[yy][xx] == 0){
                        copyMap[yy][xx] = 2;
                        queue.add(new virus(yy, xx));
                    }
                }
            }
        }
        Count(copyMap);
    }
    
    public static void Count(int[][] copyMap){
        int count = 0;
        for(int i=0; i < N; i++){
            for(int j=0; j<M; j++){
                if (copyMap[i][j] == 0) count++;
            }
        }
        maxCount = Math.max(maxCount, count);
    }
}