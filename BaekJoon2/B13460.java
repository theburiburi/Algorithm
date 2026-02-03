import java.io.*;
import java.util.*;

public class B13460 { //13460
    private static int answer = Integer.MAX_VALUE;
    private static int N, M;
    static boolean visited[][][][];
    static char arr[][];
    static int dx[] = { 0, 0, -1, 1 };
    static int dy[] = { -1, 1, 0, 0 }; // ?�하좌우

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rY = 0, rX = 0;
        int bY = 0, bX = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'R') {
                    rY = i;
                    rX = j;
                }
                if (arr[i][j] == 'B') {
                    bY = i;
                    bX = j;
                }
            }
        }

        dfs(rY, rX, bY, bX, 1);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void dfs(int redY, int redX, int blueY, int blueX, int count) {
        if (count > 10 || count >= answer)
            return;

        visited[redY][redX][blueY][blueX] = true;

        for (int i = 0; i < 4; i++) {
            int[] result = move(redY, redX, blueY, blueX, i);

            int nextRY = result[0];
            int nextRX = result[1];
            int nextBY = result[2];
            int nextBX = result[3];
            boolean isBlueHole = (result[4] == 1);
            boolean isRedHole = (result[5] == 1);

            if (isBlueHole)
                continue;

            if (isRedHole) {
                answer = Math.min(answer, count);
                continue;
            }

            if (!visited[nextRY][nextRX][nextBY][nextBX]) {
                dfs(nextRY, nextRX, nextBY, nextBX, count + 1);
            }
        }

        visited[redY][redX][blueY][blueX] = false;
    }

    public static int[] move(int rY, int rX, int bY, int bX, int dir) {
        int nextRY = rY;
        int nextRX = rX;
        int nextBY = bY;
        int nextBX = bX;

        boolean isRedHole = false;
        boolean isBlueHole = false;

        while (arr[nextRY + dy[dir]][nextRX + dx[dir]] != '#') {
            nextRY += dy[dir];
            nextRX += dx[dir];

            if (arr[nextRY][nextRX] == 'O') {
                isRedHole = true;
                break;
            }
        }
        while (arr[nextBY + dy[dir]][nextBX + dx[dir]] != '#') {
            nextBY += dy[dir];
            nextBX += dx[dir];

            if (arr[nextBY][nextBX] == 'O') {
                isBlueHole = true;
                break;
            }
        }

        if (!isRedHole && !isBlueHole && nextRY == nextBY && nextRX == nextBX) {
            int redDist = Math.abs(nextRY - rY) + Math.abs(nextRX - rX);
            int blueDist = Math.abs(nextBY - bY) + Math.abs(nextBX - bX);

            if (redDist > blueDist) {
                nextRY -= dy[dir];
                nextRX -= dx[dir];
            } else {
                nextBY -= dy[dir];
                nextBX -= dx[dir];
            }
        }

        return new int[] { nextRY, nextRX, nextBY, nextBX, isBlueHole ? 1 : 0, isRedHole ? 1 : 0 };
    }
}
