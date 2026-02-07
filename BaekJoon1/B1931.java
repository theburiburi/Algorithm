import java.io.*;
import java.util.*;

public class B1931 {
    public static class Node {
        int startAt;
        int endAt;

        public Node(int startAt, int endAt) {
            this.startAt = startAt;
            this.endAt = endAt;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        list.sort((s1, s2) -> {
            if (s1.endAt == s2.endAt) {
                return s1.startAt - s2.startAt;
            }
            return s1.endAt - s2.endAt;
        });

        int count = 0;
        int lastEndTime = 0;

        for (Node now : list) {
            if (now.startAt >= lastEndTime) {
                lastEndTime = now.endAt;
                count++;
            }
        }

        System.out.println(count);
    }
}