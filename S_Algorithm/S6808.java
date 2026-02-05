import java.io.*;
import java.util.*;

public class S6808 {
    static int kyuWin, dollWin;
    static int[] kyuCards = new int[9];
    static int[] dollCards = new int[9];
    static boolean[] visited = new boolean[9];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            kyuWin = 0; 
            dollWin = 0;
            boolean[] isKyuCard = new boolean[19];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 9; i++) {
                kyuCards[i] = Integer.parseInt(st.nextToken());
                isKyuCard[kyuCards[i]] = true;
            }

            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!isKyuCard[i]) dollCards[idx++] = i;
            }

            solve(0, 0, 0);
            sb.append("#" + t + " " + kyuWin + " " + dollWin);
        }
        System.out.println(sb);
    }

    public static void solve(int depth, int kyuScore, int dollScore) {
        if (depth == 9) {
            if (kyuScore > dollScore) kyuWin++;
            else if (kyuScore < dollScore) dollWin++;
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                
                int k = kyuCards[depth];
                int d = dollCards[i];
                int sum = k + d;

                if (k > d) {
                    solve(depth + 1, kyuScore + sum, dollScore);
                } else {
                    solve(depth + 1, kyuScore, dollScore + sum);
                }

                visited[i] = false;
            }
        }
    }
}