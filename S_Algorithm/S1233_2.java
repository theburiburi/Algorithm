import java.io.*;
import java.util.*;

public class S1233_2 {
    static String[] tree;
    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            String input = br.readLine();
            if (input == null) break;

            N = Integer.parseInt(input);
            tree = new String[N + 1];

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                tree[idx] = st.nextToken();
                // 완전 이진 트리이므로 뒤에 들어오는 자식 정보는 무시해도 됨
            }

            try {
                // 루트(1번)부터 재귀적으로 계산
                int result = (int) solve(1);
                sb.append("#").append(t).append(" ").append(result).append("\n");
            } catch (Exception e) {
                // 연산 중 오류(숫자 자리에 연산자 등)가 나면 0 출력
                sb.append("#").append(t).append(" 0\n");
            }
        }
        System.out.print(sb);
    }

    public static double solve(int idx) {
        if (idx > N) throw new RuntimeException(); // 범위를 벗어난 접근

        String val = tree[idx];
        boolean isOp = "+-*/".contains(val);

        // 1. 연산자인 경우
        if (isOp) {
            // 완전 이진 트리 기준 자식 노드 계산
            double left = solve(idx * 2);
            double right = solve(idx * 2 + 1);

            switch (val) {
                case "+": return left + right;
                case "-": return left - right;
                case "*": return left * right;
                case "/": return left / right;
            }
        }

        // 2. 숫자인 경우
        // 숫자가 자식을 가지고 있다면 (idx * 2 <= N) 잘못된 수식 트리
        if (idx * 2 <= N) throw new RuntimeException();

        return Double.parseDouble(val);
    }
}