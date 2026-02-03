import java.io.*;
import java.util.*;

public class S_1233_2 {
    static String[] arr;
    static int N;
    // 계산 불가능을 나타내는 특수 상수
    static final int ERROR = Integer.MIN_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) break;

            N = Integer.parseInt(line.trim());
            arr = new String[N + 1];

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                arr[num] = st.nextToken();
            }

            int finalResult = calculate(1);

            sb.append("#").append(t).append(" ");
            if (finalResult == ERROR) {
                sb.append(0).append("\n"); // 계산 불가능한 트리
            } else {
                sb.append(finalResult).append("\n"); // 계산된 결과값
            }
        }
        System.out.print(sb);
    }

    public static int calculate(int now) {
        if (now > N) return ERROR;

        String val = arr[now];
        boolean isOp = "+-*/".contains(val);
        int leftIdx = now * 2;
        int rightIdx = now * 2 + 1;

        if (isOp) {
            // [유효성 체크] 연산자는 반드시 자식이 둘 다 있어야 함
            if (leftIdx > N || rightIdx > N) return ERROR;

            int left = calculate(leftIdx);
            int right = calculate(rightIdx);

            // 자식 중 하나라도 에러면 에러 반환
            if (left == ERROR || right == ERROR) return ERROR;

            // 실제 사칙연산 수행
            // 실제 사칙연산 수행 (전통적인 switch 문 방식)
            switch (val) {
                case "+":
                    return left + right;
                case "-":
                    return left - right;
                case "*":
                    return left * right;
                case "/":
                    if (right == 0) return ERROR; // 0으로 나누기 방지
                    return left / right;
                default:
                    return ERROR;
            }
        } else {
            // [유효성 체크] 숫자는 자식이 없어야 함
            if (leftIdx <= N) return ERROR;

            try {
                return Integer.parseInt(val);
            } catch (NumberFormatException e) {
                return ERROR;
            }
        }
    }
}