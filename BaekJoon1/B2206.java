import java.io.*;
import java.util.*;

public class B2206 {
    static class Node{
        int y;
        int x;
        int visit;
        public Node(int y, int x, int visit){
            this.y = y;
            this.x = x;
            this.visit = visit;
        }
    }
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static final int INF = 1000001;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][M];
        for(int i=0; i<N; i++){
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int visited[][][] = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(visited[i][j], INF); 
            }
        }
        visited[0][0][0] = 1;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, 0));

        while(!que.isEmpty()){
            Node now = que.poll();
            int y = now.y;
            int x = now.x;

            for(int i=0;i<4; i++){
                int ny = y+dy[i];
                int nx = x+dx[i];
                
                if(0<= ny && ny <N && 0<=nx && nx <M){
                    if(now.visit == 1){
                        if(arr[ny][nx] == 0 && visited[ny][nx][1] > visited[y][x][1]+1){
                            visited[ny][nx][1] = visited[y][x][1]+1;
                            que.add(new Node(ny,nx,1));
                        }
                    }
                    else{
                        if(arr[ny][nx] == 0 && visited[ny][nx][0] > visited[y][x][0]+1){
                            visited[ny][nx][0] = visited[y][x][0]+1;
                            que.add(new Node(ny,nx,0));
                        }
                        else if(arr[ny][nx] == 1 && visited[ny][nx][1] > visited[y][x][0] + 1){
                            visited[ny][nx][1] = visited[y][x][0] + 1;
                            que.add(new Node(ny,nx,1));
                        }
                    }
                }
            }
        }
        int ans = visited[N-1][M-1][0] < visited[N-1][M-1][1] ? visited[N-1][M-1][0] : visited[N-1][M-1][1];
        if(ans == INF) ans = -1;
        System.out.println(ans);
    }
}
