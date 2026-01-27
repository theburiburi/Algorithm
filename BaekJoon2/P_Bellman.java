import java.util.ArrayList;
import java.util.Arrays;



public class P_Bellman {
    static class Node {
        int endPoint;
        int cost;

        Node(int endPoint, int cost) {
            this.endPoint = endPoint;
            this.cost = cost;
        }
    }

    static final int INF = 999;
    static final int graph1Size = 6;
    static final int graph2Size = 7;

    static ArrayList<Node>[] dist1 = new ArrayList[graph1Size + 1];
    static ArrayList<Node>[] dist2 = new ArrayList[graph2Size + 1];

    static int[][] graph1Edges = { {1, 2, 1}, {1, 4, 4}, {2, 3, 3}, {2, 5, 1}, {3, 5, 1}, {3, 6, 2}, {4, 5, 1}, {5, 6, 4} };
    static int[][] graph2Edges = { {1, 2, 4}, {1, 3, 5}, {2, 3, 6}, {2, 4, 5}, {2, 5, 10}, {3, 4, 4}, {3, 6, 9}, {4, 5, 6}, {4, 6, 3}, {5, 6, 3}, {5, 7, 2}, {6, 7, 2} };

    public static void main(String[] args) {
        for (int i = 0; i <= graph1Size; i++) {
            dist1[i] = new ArrayList<>();
        }

        for (int i = 0; i <= graph2Size; i++) {
            dist2[i] = new ArrayList<>();
        }

        setGraph(graph1Edges, dist1);
        setGraph(graph2Edges, dist2);

        System.out.println("graph1");
        for (int i = 1; i <= graph1Size; i++) {
            bellmanFord(i, graph1Size, dist1);
        }

        System.out.println();
        System.out.println("graph2");
        for (int i = 1; i <= graph2Size; i++) {
            bellmanFord(i, graph2Size, dist2);
        }
    }

    static void printGraph(int source, int destination, int finalDestination, int[] weight, ArrayList<Node>[] dist, ArrayList<Integer> path, int graphSize) {
        for (int start = 1; start <= graphSize; start++) {
            for (Node node : dist[start]) {
                if (node.endPoint == destination && weight[start] + node.cost == weight[destination] && start != destination) {
                    if (start == source) {
                        System.out.printf("%10s %d -> ", "*", source);
                        while (path.get(path.size() - 1) != finalDestination) {
                            System.out.printf("%d -> ", path.remove(path.size() - 1));
                        }
                        System.out.printf("%d\n", path.get(path.size() - 1));
                    } else {
                        path.add(start);
                        printGraph(source, start, finalDestination, weight, dist, path, graphSize);
                    }
                }
            }
        }
    }

    static void setGraph(int[][] graph, ArrayList<Node>[] dist) {
        for (int[] edge : graph) {
            int start = edge[0];
            int end = edge[1];
            int cost = edge[2];
            dist[start].add(new Node(end, cost));
            dist[end].add(new Node(start, cost));
        }
    }

    static void bellmanFord(int index, int graphSize, ArrayList<Node>[] dist) {
        int[] weight = new int[graphSize + 1];
        Arrays.fill(weight, INF);
        weight[index] = 0;

        for (int i = 1; i <= graphSize; i++) {
            if (i == graphSize) {
                System.out.println();
                System.out.println("<<<-------- 노드 " + index + " -------->>>");
                for (int destination = 1; destination <= graphSize; destination++) {
                    if (destination == index) continue;
                    ArrayList<Integer> path = new ArrayList<>();
                    path.add(destination);
                    System.out.print("[ " + index + " -> " + destination + " ]");
                    System.out.println(", cost : " + weight[destination]);
                    printGraph(index, destination, destination, weight, dist, path, graphSize);
                }
                return;
            }

            for (int j = 1; j <= graphSize; j++) {
                if (j == index) continue;
                int tempCost = INF;
                for (Node node : dist[j]) {
                    tempCost = Math.min(tempCost, weight[node.endPoint] + node.cost);
                }
                weight[j] = tempCost;
            }
        }
    }
}
