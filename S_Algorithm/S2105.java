import java.io.*;
import java.util.*;

public class S2105 {
    static StringBuilder sb;
    static int N, ans;
    static int[][] arr;
    static boolean[] visited;

    static int startY, startX;
    static int[] dy = {1, 1, -1, -1};
    static int[] dx = {1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        readInput();
        System.out.print(sb.toString());
    }

    public static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = -1;
            solution();
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
    }

    public static void solution() {
        for (int i = 0; i < N - 2; i++) {
            for (int j = 1; j < N - 1; j++) {
                startY = i;
                startX = j;
                visited = new boolean[101];
                visited[arr[i][j]] = true;
                dfs(i, j, 0, 1);
            }
        }
    }

    public static void dfs(int y, int x, int d, int count) {
        for (int i = d; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny == startY && nx == startX && count >= 4) {
                ans = Math.max(ans, count);
                return;
            }

            if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;

            if (!visited[arr[ny][nx]]) {
                visited[arr[ny][nx]] = true;
                dfs(ny, nx, i, count + 1);
                visited[arr[ny][nx]] = false;
            }
        }
    }
}