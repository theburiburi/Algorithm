import java.io.*;
import java.util.*;

public class B6549 {
    static int N;
    static long[] height;
    static StringBuilder sb;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        while (inputFile()) {
            solution();
        }
        System.out.println(sb.toString());
    }

    static boolean inputFile() throws IOException {
        String line = br.readLine();
        if (line == null || line.equals("0")) return false;

        StringTokenizer st = new StringTokenizer(line);
        N = Integer.parseInt(st.nextToken());
        
        if (N == 0) return false;

        height = new long[N + 2];
        for (int i = 1; i <= N; i++) {
            height[i] = Long.parseLong(st.nextToken());
        }
        return true;
    }

    static void solution() {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        long maxArea = 0;

        for (int i = 1; i <= N + 1; i++) {
            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                long h = height[stack.pop()];
                int w = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }

        sb.append(maxArea).append("\n");
    }
}