import java.io.*;
import java.util.*;

public class S5656 {
    static StringBuilder sb;
    static int N, W, H;
    static int maxAns;

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    public static void main(String args[]) throws IOException {
        readInput();
        System.out.println(sb.toString());
    }

    public static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            int[][] arr = new int[H][W];
            int[] height = new int[W];
            Arrays.fill(height, -1);

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] != 0 && height[j] == -1) {
                        height[j] = i;
                    }
                }
            }
            
            for (int j = 0; j < W; j++) if (height[j] == -1) height[j] = H;

            maxAns = Integer.MAX_VALUE;
            dfs(0, arr, height);
            sb.append("#").append(t).append(" ").append(maxAns).append("\n");
        }
    }

    public static void dfs(int count, int nowArr[][], int nowHeight[]) {
        if (count == N) {
            int ans = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (nowArr[i][j] != 0) ans++;
                }
            }
            maxAns = Math.min(maxAns, ans);
            return;
        }

        for (int j = 0; j < W; j++) {
            if (nowHeight[j] == H) {
                dfs(count + 1, nowArr, nowHeight);
                continue;
            }

            int[][] nextArr = new int[H][W];
            for (int i = 0; i < H; i++) nextArr[i] = nowArr[i].clone();
            int[] nextHeight = nowHeight.clone();

            bomb(nextHeight[j], j, nextArr);
            gravity(nextArr, nextHeight);
            dfs(count + 1, nextArr, nextHeight);
        }
    }

    public static void bomb(int y, int x, int newArr[][]) {
        if (newArr[y][x] == 0) return;

        int nextSize = newArr[y][x];
        newArr[y][x] = 0;

        for (int size = 1; size < nextSize; size++) {
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i] * size;
                int nx = x + dx[i] * size;
                if (ny < 0 || ny >= H || nx < 0 || nx >= W) continue;

                bomb(ny, nx, newArr);
            }
        }
    }

    public static void gravity(int newArr[][], int nextHeight[]) {
        for (int j = 0; j < W; j++) {
            int temp[] = new int[H];
            int idx = 0;
            
            for (int i = H - 1; i >= 0; i--) {
                if (newArr[i][j] != 0) {
                    temp[idx++] = newArr[i][j];
                }
            }

            nextHeight[j] = H; 
            for (int i = H - 1; i >= 0; i--) {
                newArr[i][j] = temp[H - 1 - i];
                if (newArr[i][j] != 0) {
                    nextHeight[j] = i;
                }
            }
        }
    }
}