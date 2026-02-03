import java.io.*;
import java.util.*;

public class B1781 {//1781 그리??
    static class Node implements Comparable<Node> {
        int deadline, ramenNum;

        public Node(int deadline, int ramenNum) {
            this.deadline = deadline;
            this.ramenNum = ramenNum;
        }

        @Override
        public int compareTo(Node o) {
            return this.deadline - o.deadline;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Node[] problems = new Node[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int ramenNum = Integer.parseInt(st.nextToken());
            problems[i] = new Node(deadline, ramenNum);
        }

        Arrays.sort(problems);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Node problem : problems) {
            pq.add(problem.ramenNum);
            if (pq.size() > problem.deadline) {
                pq.poll();
            }
        }

        int totalRamen = 0;
        while (!pq.isEmpty()) {
            totalRamen += pq.poll();
        }

        System.out.println(totalRamen);
    }
}
