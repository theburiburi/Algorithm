import java.io.*;
import java.util.*;

public class S1251_2 {
    static StringBuilder sb;
    static int N;
    static double E;
    static long[] xPos, yPos;
    static boolean[] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            xPos = new long[N];
            yPos = new long[N];

            StringTokenizer stX = new StringTokenizer(br.readLine());
            StringTokenizer stY = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                xPos[i] = Long.parseLong(stX.nextToken());
                yPos[i] = Long.parseLong(stY.nextToken());
            }
            E = Double.parseDouble(br.readLine());

            sb.append("#").append(t).append(" ").append(solve()).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static long solve() {
        long[] minEdge = new long[N];
        Arrays.fill(minEdge, Long.MAX_VALUE);
        visited = new boolean[N];

        long totalDistanceL2 = 0;
        minEdge[0] = 0;

        for (int i = 0; i < N; i++) {
            long min = Long.MAX_VALUE;
            int minIdx = -1;

            for (int j = 0; j < N; j++) {
                if (!visited[j] && min > minEdge[j]) {
                    min = minEdge[j];
                    minIdx = j;
                }
            }

            if (minIdx == -1) break;

            visited[minIdx] = true;
            totalDistanceL2 += min;

            for (int j = 0; j < N; j++) {
                if (!visited[j]) {
                    long dist = getDistanceL2(minIdx, j);
                    if (minEdge[j] > dist) {
                        minEdge[j] = dist;
                    }
                }
            }
        }

        return Math.round(totalDistanceL2 * E);
    }

    static long getDistanceL2(int i, int j) {
        return (xPos[i] - xPos[j]) * (xPos[i] - xPos[j]) +
               (yPos[i] - yPos[j]) * (yPos[i] - yPos[j]);
    }
}