import java.io.*;
import java.util.*;

public class S5215_3 {
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
            subset(0, 0, 0);

            System.out.println("#" + t + " " + maxScore);
        }
    }

    public static void subset(int depth, int scoreSum, int kcalSum) {
        if (depth >= N) {
            maxScore = Math.max(maxScore, scoreSum);
            return;
        }

        subset(depth+1, scoreSum, kcalSum);
        
        if(kcalSum + kcals[depth] <= L){
            subset(depth+1, scoreSum + scores[depth], kcalSum + kcals[depth]);
        }
    }
}