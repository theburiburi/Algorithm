import java.io.*;
import java.util.*;

public class 2287 {//2287 해쉬셋
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        HashSet<Integer>[] dp = new HashSet[9];
        for (int i = 1; i <= 8; i++) dp[i] = new HashSet<>();

        int initVal = k;
        for (int i = 1; i <= 8; i++) {
            dp[i].add(initVal);
            initVal = initVal * 10 + k;
        }

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= i / 2; j++) {
                int diff = i - j;
                for (int aVal : dp[diff]) {
                    for (int bVal : dp[j]) {
                        dp[i].add(aVal + bVal);
                        dp[i].add(aVal - bVal);
                        dp[i].add(bVal - aVal);
                        dp[i].add(aVal * bVal);
                        if (bVal != 0) dp[i].add(aVal / bVal);
                        if (aVal != 0) dp[i].add(bVal / aVal);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int result = 0;
            for (int t = 1; t <= 8; t++) {
                if (dp[t].contains(a[i])) {
                    result = t;
                    break;
                }
            }

            if (result == 0) sb.append("NO\n");
            else sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
