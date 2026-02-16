import java.util.*;
import java.io.*;

public class S14510 {
    static int N, maxTall;
    static int cnt1, cnt2, ans;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        inputFile();
        System.out.print(sb.toString());
    }

    public static void inputFile() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            maxTall = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                maxTall = Math.max(maxTall, arr[i]);
            }

            cnt1 = 0;
            cnt2 = 0;
            ans = 0;

            solution();
            sb.append('#').append(t).append(' ').append(ans).append('\n');
        }
    }
    public static void solution(){
        for (int i = 0; i < N; i++) {
            int diff = maxTall - arr[i];

            if (diff == 0) continue;
            
            cnt1 += diff % 2;
            cnt2 += diff / 2;
        }

        while (cnt2 > cnt1+1) {
            cnt2--;
            cnt1 += 2;
        }

        if (cnt1 > cnt2) {ans = cnt1 * 2 - 1;}
        else {ans = cnt2 * 2;}
    }
}
