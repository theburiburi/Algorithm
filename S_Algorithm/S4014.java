import java.io.*;
import java.util.*;

public class S4014 {
    static int N, X, ans;
    static int[][] arr;
    static StringBuilder sb;
    public static void main(String args[]) throws IOException {
        inputFile();
        System.out.println(sb.toString());
    }

    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            solve(t);
        }
    }
    
    static void solve(int t){
        ans = 0;
        for (int i = 0; i < N; i++) {
            int[] col = new int[N];
            for (int j = 0; j < N; j++) {
                col[j] = arr[j][i];
            }
            if (checkLine(arr[i])) ans++;
            if (checkLine(col)) ans++;
        }
        sb.append("#").append(t).append(" ").append(ans).append("\n");
    }

    static boolean checkLine(int[] line) {
        boolean[] install = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            if (line[i] == line[i + 1]) continue;

            int diff = line[i] - line[i + 1];

            if (Math.abs(diff) > 1) return false;

            if (diff == 1) { // 하락
                for (int k = 1; k <= X; k++) {
                    if (i + k >= N || line[i + 1] != line[i + k] || install[i + k]) return false;
                    install[i + k] = true;
                }
                i += X - 1;
            } 
            else if (diff == -1) { // 상승
                for (int k = 0; k < X; k++) {
                    if (i - k < 0 || line[i] != line[i - k] || install[i - k]) return false;
                    install[i - k] = true;
                }
            }
        }
        return true;
    }
}