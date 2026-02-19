import java.io.*;
import java.util.*;

public class S1227{
    static StringBuilder sb;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int startX, startY;
    public static void main(String args[])throws IOException{
        inputFile();
        System.out.println(sb.toString());
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int T = Integer.parseInt(br.readLine());
            arr = new int[100][100];

            for (int i = 0; i < 100; i++) {
                String str = br.readLine();
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = str.charAt(j) - '0';
                    if (arr[i][j] == 2) {
                        startX = i;
                        startY = j;
                    }
                }
            }

            sb.append("#").append(T).append(" ").append(bfs()).append("\n");
        }
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        
        arr[startX][startY] = 1; 

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100) continue;

                if (arr[nx][ny] == 3) {
                    return 1;
                }
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return 0;
    }
}
