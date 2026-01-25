import java.io.*;
import java.util.*;

public class P_11066 {//?êÎ∞î dp
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            int[] arr = new int[K + 1];
            int[][] dp = new int[K + 1][K + 1];
            int[] prefixSum = new int[K + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                prefixSum[i] = prefixSum[i - 1] + arr[i];
            }

            for (int len = 2; len <= K; len++) {
                for (int i = 1; i + len - 1 <= K; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;

                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + prefixSum[j] - prefixSum[i - 1]);
                    }
                }
            }

            sb.append(dp[1][K]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
