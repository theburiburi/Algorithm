import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int endPoint;
    int cost;

    Node(int endPoint, int cost) {
        this.endPoint = endPoint;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node O) {
        return this.cost - O.cost;
    }
}

public class Dijkstra {

    static final int INF = 999;
    static final int graph1Size = 6;
    static final int graph2Size = 7;

    static ArrayList<Node>[] graph1 = new ArrayList[graph1Size + 1];  
    static ArrayList<Node>[] graph2 = new ArrayList[graph2Size + 1];  
    static int[] dist = new int[graph2Size + 1];
    static boolean[] visited = new boolean[graph2Size + 1];

    static int[][] graph1Edges = { {1, 2, 1}, {1, 4, 4}, {2, 3, 3}, {2, 5, 1}, {3, 5, 1}, {3, 6, 2}, {4, 5, 1}, {5, 6, 4} };
    static int[][] graph2Edges = { {1, 2, 4}, {1, 3, 5}, {2, 3, 6}, {2, 4, 5}, {2, 5, 10}, {3, 4, 4}, {3, 6, 9}, {4, 5, 6}, {4, 6, 3}, {5, 6, 3}, {5, 7, 2}, {6, 7, 2} };

    public static void main(String[] args) {
        for (int i = 0; i <= graph1Size; i++) {
            graph1[i] = new ArrayList<>();
        }

        for (int i = 0; i <= graph2Size; i++) {  
            graph2[i] = new ArrayList<>();
        }

        System.out.println("graph1");
        setGraph(graph1Edges, graph1);
        dijkstra(1, graph1Size, graph1);

        System.out.println();
        System.out.println("graph2");
        setGraph(graph2Edges, graph2);
        dijkstra(1, graph2Size, graph2);
    }

    static void setGraph(int[][] edges, ArrayList<Node>[] graph) {
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int cost = edge[2];
            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }
    }

    static void dijkstra(int startNode, int graphSize, ArrayList<Node>[] graph) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
        dist[startNode] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startNode, 0));

        ArrayList<Integer> selectedNodes = new ArrayList<>(); 

        printGraph(selectedNodes, dist, graphSize);

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (!visited[now.endPoint]) {
                visited[now.endPoint] = true;

                for (Node next : graph[now.endPoint]) {
                    if (!visited[next.endPoint] && dist[next.endPoint] > now.cost + next.cost) {
                        dist[next.endPoint] = now.cost + next.cost;
                        pq.add(new Node(next.endPoint, dist[next.endPoint]));
                    }
                }

                selectedNodes.add(now.endPoint);
                printGraph(selectedNodes, dist, graphSize);
            }
        }
    }

    static void printGraph(ArrayList<Integer> selectedNodes, int[] distances, int graphSize) {
        System.out.println("Step 1");
        System.out.print("P = { ");
        for (int node : selectedNodes) {
            System.out.print(node + " ");
        }
        System.out.println("}");

        System.out.println("Step 2");
        System.out.print("D = [ ");
        for (int i = 1; i <= graphSize; i++) {
            if (distances[i] == INF) {
                System.out.printf("%3s ", "INF");
            } else {
                System.out.printf("%3d ", distances[i]);
            }
        }
        System.out.println("]");
    }
}

