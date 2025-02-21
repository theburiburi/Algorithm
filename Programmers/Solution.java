import java.util.*;

class Solution {
    static List<Integer> graph[];
    static int nodeLen;

    public int[] solution(int[] nodes, int[][] edges) {
        nodeLen = nodes.length;
        graph = new ArrayList[nodeLen + 1];

        for (int i = 0; i <= nodeLen; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int edge[] : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean visited[] = new boolean[nodeLen + 1];
        int oddEvenTree = 0;
        int revOddEvenTree = 0;

        for (int i = 1; i <= nodeLen; i++) {
            if (!visited[i]) {
                int nodeType[] = new int[nodeLen + 1];
                boolean[] isOddEven = new boolean[1];
                boolean[] isRevOddEven = new boolean[1];

                dfs(i, -1, visited, nodes, nodeType, isOddEven, isRevOddEven);

                if (isOddEven[0]) oddEvenTree++;
                if (isRevOddEven[0]) revOddEvenTree++;
            }
        }

        return new int[]{oddEvenTree, revOddEvenTree};
    }

    private int dfs(int node, int parent, boolean[] visited, int[] nodes, int[] nodeType, boolean[] isOddEven, boolean[] isRevOddEven) {
        visited[node] = true;
        int childCount = 0;

        for (int neighbor : graph[node]) {
            if (neighbor == parent) continue; // 부모 노드는 제외
            if (!visited[neighbor]) {
                childCount += dfs(neighbor, node, visited, nodes, nodeType, isOddEven, isRevOddEven);
            }
        }

        // 현재 노드의 유형 판별
        boolean isOdd = nodes[node - 1] % 2 == 1;  // 노드 번호가 홀수인지
        boolean isChildrenOdd = childCount % 2 == 1;  // 자식 개수가 홀수인지

        if (isOdd && isChildrenOdd) nodeType[node] = 1; // 홀수 노드
        else if (!isOdd && !isChildrenOdd) nodeType[node] = 2; // 짝수 노드
        else if (isOdd && !isChildrenOdd) nodeType[node] = 3; // 역홀수 노드
        else nodeType[node] = 4; // 역짝수 노드

        // 트리 유형 판별
        if (nodeType[node] == 1 || nodeType[node] == 2) isOddEven[0] = true;
        if (nodeType[node] == 3 || nodeType[node] == 4) isRevOddEven[0] = true;

        return childCount + 1;  // 현재 노드를 포함한 자식 개수 반환
    }
}
