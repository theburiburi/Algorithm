import java.util.ArrayList;

class Node {
    int endPoint;
    int cost;

    Node(int endPoint, int cost) {
        this.endPoint = endPoint;
        this.cost = cost;
    }
}

public class Warshall {

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
            for (int j = 0; j <= graph1Size; j++) {
                if (i == j) {
                    dist1[i].add(new Node(j, 0));
                } else {
                    dist1[i].add(new Node(j, INF));
                }
            }
        }

        for (int i = 0; i <= graph2Size; i++) {
            dist2[i] = new ArrayList<>();
            for (int j = 0; j <= graph2Size; j++) {
                if (i == j) {
                    dist2[i].add(new Node(j, 0));
                } else {
                    dist2[i].add(new Node(j, INF));
                }
            }
        }

        setGraph(graph1Edges, dist1);
        System.out.println("graph1 : ");
        floydWarshall(graph1Size, dist1);

        setGraph(graph2Edges, dist2);
        System.out.println("\ngraph2 : ");
        floydWarshall(graph2Size, dist2);
    }

    static void setGraph(int[][] graph, ArrayList<Node>[] dist) {
        for (int[] edge : graph) {
            int start = edge[0];
            int end = edge[1];
            int cost = edge[2];
            dist[start].set(end, new Node(end, cost));
            dist[end].set(start, new Node(start, cost));
        }
    }

    static void floydWarshall(int graphSize, ArrayList<Node>[] dist) {
        System.out.println("Floyd 실행 전");
        printGraph(graphSize, dist);

        for (int z = 1; z <= graphSize; z++) {
            for (int i = 1; i <= graphSize; i++) {
                for (int j = 1; j <= graphSize; j++) {
                    int currentCost = dist[i].get(j).cost;
                    int newCost = dist[i].get(z).cost + dist[z].get(j).cost;
                    if (currentCost > newCost) {
                        dist[i].set(j, new Node(j, newCost));
                    }
                }
            }

            System.out.println("middle " + z);
            printGraph(graphSize, dist);
        }

        System.out.println("Floyd 실행 후");
        printGraph(graphSize, dist);
    }

    static void printGraph(int graphSize, ArrayList<Node>[] dist) {
        for (int i = 1; i <= graphSize; i++) {
            for (int j = 1; j <= graphSize; j++) {
                if (dist[i].get(j).cost == INF) {
                    System.out.printf("%3s ", "INF");
                } else {
                    System.out.printf("%3d ", dist[i].get(j).cost);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
