import java.io.*;
import java.util.*;

public class S4796 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        String token = next();
        if (token == null) return; 
        int T = Integer.parseInt(token);

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(next());

            boolean increase = true;
            int num = 0;
            int count = -1; 
            int ans = 0;

            for (int i = 0; i < N; i++) {
                int next = Integer.parseInt(next()); 

                if (num < next) { // 증가
                    if (!increase) {
                        count = 0;
                    }
                    count++;
                    increase = true;
                } else { // 감소하는 경우
                    if (count > 0) ans += count;
                    increase = false;
                }
                num = next;
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }
}