import java.io.*;
import java.util.*;

public class S5658 {
    static StringBuilder sb;
    static int N, K;
    static char[] arr;
    static Set<Integer> set; 

    public static void main(String args[]) throws IOException {
        readInput();
        System.out.println(sb.toString());
    }

    public static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new char[N]; 
            String str = br.readLine();
            for (int i = 0; i < N; i++) {
                arr[i] = str.charAt(i);
            }
            
            set = new TreeSet<>(Collections.reverseOrder());
            
            sb.append("#").append(t).append(" ");
            solve();
        }
    }

    public static void solve() {
        int lineCnt = N / 4; 

        for (int i = 0; i < N; i++) { 
            int num = 0;
            
            for (int j = 0; j < lineCnt; j++) {
                char now = arr[(i + j) % N]; 
                
                int digit;
                if ('A' <= now && now <= 'F') {
                    digit = now - 'A' + 10;
                } else {
                    digit = now - '0';
                }
                
                num = num * 16 + digit; 
            }
            
            set.add(num);
        }

        int count = 1;
        for (int num : set) {
            if (count == K) {
                sb.append(num).append("\n");
                return; 
            }
            count++;
        }
    }
}