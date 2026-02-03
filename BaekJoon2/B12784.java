import java.io.*;
import java.util.*;

public class B12784{//tree
static List<Edge>[]adj;static boolean[]visited;

static class Edge {
    int to, cost;

    Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            adj = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            for (int i = 1; i <= N; i++)
                adj[i] = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                adj[u].add(new Edge(v, w));
                adj[v].add(new Edge(u, w));
            }

            long result = dfs(1, Integer.MAX_VALUE);
            if (result == Integer.MAX_VALUE)
                result = 0;

            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    public static long dfs(int now, int costToParent) {
        visited[now] = true;
        long sum = 0;
        boolean isLeaf = true;

        for (Edge edge : adj[now]) {
            if (!visited[edge.to]) {
                isLeaf = false;
                sum += dfs(edge.to, edge.cost);
            }
        }

        if (isLeaf)
            return costToParent;

        return Math.min((long) costToParent, sum);
    }
}
