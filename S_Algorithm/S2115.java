import java.io.*;
import java.util.*;

public class S2115 {
    static int M, N, C;
    static int tempAns;
    static int[][] arr, S;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            arr = new int[N + 1][N + 1];
            S = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    S[i][j] = S[i][j - 1] + arr[i][j];
                }
            }

            int ans = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = M; j <= N; j++) {
                    int upperSum = 0;
                    int sum1 = S[i][j] - S[i][j - M];

                    if (sum1 > C) {
                        tempAns = 0;
                        combination(i, j - M + 1, 0, 0, 0);
                        upperSum = tempAns;
                    } else {
                        upperSum = calArr(i, j - M + 1);
                    }

                    for (int y = i; y <= N; y++) {
                        int startX = (i == y) ? j + M : M;
                        for (int x = startX; x <= N; x++) {
                            int lowerSum = 0;
                            int sum2 = S[y][x] - S[y][x - M];

                            if (sum2 > C) {
                                tempAns = 0;
                                combination(y, x - M + 1, 0, 0, 0);
                                lowerSum = tempAns;
                            } else {
                                lowerSum = calArr(y, x - M + 1);
                            }
                            ans = Math.max(ans, upperSum + lowerSum);
                        }
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

    public static void combination(int y, int xL, int depth, int total, int powSum) {
        if (total > C) return;

        if (depth == M) {
            tempAns = Math.max(tempAns, powSum);
            return;
        }

        combination(y, xL, depth + 1, total + arr[y][xL + depth], powSum + (arr[y][xL + depth] * arr[y][xL + depth]));
        combination(y, xL, depth + 1, total, powSum);
    }

    public static int calArr(int y, int x) {
        int sum = 0;
        for (int i = x; i < x + M; i++) {
            sum += arr[y][i] * arr[y][i];
        }
        return sum;
    }
}