import java.io.*;
import java.util.*;

public class S4796 {
    static StringBuilder sb;

    public static void main(String args[]) {
        readInput();
        System.out.print(sb);
    }

    public static void readInput() {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        if (!sc.hasNextInt()) return;
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();

            boolean increase = true;
            int num = 0;
            int count = -1;
            int ans = 0;

            for (int i = 0; i < N; i++) {
                int temp = sc.nextInt();

                if (num < temp) { // 증가
                    if (!increase) {
                        count = 0;
                    }
                    count++;
                    increase = true;
                } else { // 감소할 때
                    if (count > 0) ans += count;
                    increase = false;
                }
                num = temp;
            }
            sb.append("#" + t + " " + ans + "\n");
        }
    }
}