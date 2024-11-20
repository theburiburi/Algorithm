import java.io.*;
import java.util.*;

public class 28707 {
    static int N, M;
    static int[] prob, ans;
    static List<Node>[] list;
    static Map<String, Integer> map = new HashMap<>();

    static class Node implements Comparable<Node> {
        int arr[];
        int cost;

        public Node(int arr[], int cost) {
            this.arr = arr;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        prob = Arrays.stream(br.readLine().split(" "))
                     .mapToInt(Integer::parseInt)
                     .toArray();
                     
        ans = prob.clone();
        Arrays.sort(ans);

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(new int[]{b}, c));
        }

        solution();
    }

    static void solution() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(prob, 0));
        map.put(Arrays.toString(prob), 0);

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (Arrays.equals(ans, now.arr)) {
                System.out.println(now.cost);
                return;
            }

            for (int i = 0; i < N; i++) {
                for (Node changeNode : list[i]) {

                    int[] duple = now.arr.clone();
                    int swapIndex = changeNode.arr[0];

                    int temp = duple[i];
                    duple[i] = duple[swapIndex];
                    duple[swapIndex] = temp;

                    String key = Arrays.toString(duple);
                    int newCost = now.cost + changeNode.cost;

                    if (!map.containsKey(key) || map.get(key) > newCost) {
                        map.put(key, newCost);
                        pq.add(new Node(duple, newCost));
                    }
                }
            }
        }
        System.out.println(-1);
    }
}