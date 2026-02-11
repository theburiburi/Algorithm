import java.util.*;
import java.io.*;

public class B17472 {
    static int N, M;
    static Queue<int[]> queue;
    static LinkedList<Integer> landConnect[];
    static List<int[]> landPostion[];
    static boolean visited[][];

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int arr[][];

    static int landNum = 1;
    public static void main(String[] args) throws IOException{
        inputFile();
    }

    public static void inputFile() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(visited[i][j] == false && arr[i][j] == 1){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty()){
            int ij[] = queue.poll();
            if(visited[ij[0]][ij[1]] == true) continue;
            bfs(ij[0], ij[1]);
        }

        solution();
    }

    public static void solution() {
        landConnect = new LinkedList[landNum];
        boolean visited[] = new boolean[landNum];
        landPostion = new List[landNum];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] != 0){
                    landPostion[arr[i][j]].add(new int[]{i, j});
                }
            }
        }

        connectLand(1);
    }
    public static void bfs(int y, int x) {
        Queue<int[]> que = new LinkedList<>();

        while(!que.isEmpty()) {
            int[] cur = queue.poll();
            int nx = cur[0];
            int ny = cur[1];
            arr[x][y] = landNum;

            for(int i=0;i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
        landNum++;
    }
    public static void connectLand(int landNum, int bridgeLength) {
        
    }
    
}