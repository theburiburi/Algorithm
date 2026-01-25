import java.io.*;
import java.util.*;

public class S_1868 {
    static char arr[][];
    static int dotCount[][];
    static boolean visited[][];
    static int dx[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int dy[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int N;
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            int answer = 0;
            N = Integer.parseInt(br.readLine());
            arr = new char[N][N];
            dotCount = new int[N][N];
            visited = new boolean[N][N];

            for(int i=0; i<N; i++){
                arr[i] = br.readLine().toCharArray();
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(arr[i][j]=='.'){
                        dotCount[i][j] = getCount(i, j);
                    }
                    else{
                        dotCount[i][j] = -1;
                    }
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(dotCount[i][j] == 0 && !visited[i][j]){
                        answer++;
                        bfs(i,j);
                    }
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(arr[i][j] == '.' && !visited[i][j]){
                        answer++;
                    }
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb);
    }

    public static int getCount(int i, int j){
        int count = 0;
        for(int k=0; k<8; k++){
            int ddy = i + dy[k];
            int ddx = j + dx[k];
            if(0<=ddx && ddx < N && 0 <= ddy && ddy < N){
                if(arr[ddy][ddx] == '*') count++;
            }
        }
        return count;
    }

    public static void bfs(int i, int j){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{i,j});
        visited[i][j] = true;

        while(!que.isEmpty()){
            int now[] = que.poll();
            if(dotCount[now[0]][now[1]] == 0){
                for(int k=0; k<8; k++){
                    int ddy = now[0] + dy[k];
                    int ddx = now[1] + dx[k];
                    if(0<=ddx && ddx < N && 0 <= ddy && ddy < N && !visited[ddy][ddx]){
                        visited[ddy][ddx] = true;
                        if(dotCount[ddy][ddx] == 0){
                            que.add(new int[]{ddy, ddx});
                        }
                    }
                }
            }
        }
    }
}

