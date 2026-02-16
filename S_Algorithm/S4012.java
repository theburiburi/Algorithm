import java.util.*;
import java.io.*;
 
public class S4012 {
    static int N, ans;
    static int[][] synergy;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws IOException {
        inputFile();
        System.out.print(sb.toString());
    }
 
    public static void inputFile() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            synergy = new int[N][N];
            visited = new boolean[N];
            ans = Integer.MAX_VALUE;
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    synergy[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            visited[0] = true;
            combination(1, 1);
             
            sb.append('#').append(t).append(' ').append(ans).append('\n');
        }
    }
 
    public static void combination(int start, int count) {
        if (count == N / 2) {
            calculate();
            return;
        }
 
        for (int i = start; i < N; i++) {
            visited[i] = true;
            combination(i + 1, count + 1);
            visited[i] = false;
        }
    }
 
    public static void calculate() {
        int sumA = 0;
        int sumB = 0;
 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                 
                if (visited[i] && visited[j]) {
                    sumA += synergy[i][j];
                }
                else if (!visited[i] && !visited[j]) {
                    sumB += synergy[i][j];
                }
            }
        }
 
        ans = Math.min(ans, Math.abs(sumA - sumB));
    }
}
