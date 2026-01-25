import java.util.*;
import java.io.*;

public class P_1049 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int min6 = Integer.MAX_VALUE;
        int min1 = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            min6 = Math.min(min6, Integer.parseInt(st.nextToken()));
            min1 = Math.min(min1, Integer.parseInt(st.nextToken()));
        }

        int res1 = N * min1;
        int res2 = (N / 6) * min6 + (N % 6) * min1;
        int res3 = ((N / 6) + 1) * min6;

        System.out.println(Math.min(res1, Math.min(res2, res3)));
    }
}
