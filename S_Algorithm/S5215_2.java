import java.io.*;
import java.util.*;

public class S5215_2 {
    static int N, L, maxScore;
    static int[] scores, kcals;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            scores = new int[N];
            kcals = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                scores[i] = Integer.parseInt(st.nextToken());
                kcals[i] = Integer.parseInt(st.nextToken());
            }

            maxScore = 0;
            generateCombination(0, 0, 0);

            System.out.println("#" + t + " " + maxScore);
        }
    }

    public static void generateCombination(int cnt, int scoreSum, int kcalSum) {
        if (kcalSum > L) return;

        if (cnt == N) {
            maxScore = Math.max(maxScore, scoreSum);
            return;
        }

        generateCombination(cnt + 1, scoreSum + scores[cnt], kcalSum + kcals[cnt]);
        generateCombination(cnt + 1, scoreSum, kcalSum);
    }
}