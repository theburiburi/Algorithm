import java.io.*;
import java.util.*;

public class B7432 { // 7432 String
    static class Node {
        String name;
        Map<String, Node> map = new TreeMap<>(); 

        public Node(String name) {
            this.name = name;
        }
    }

    static StringBuilder sb;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String line = br.readLine();
        if (line == null) return;
        
        int N = Integer.parseInt(line.trim());
        Node root = new Node("root");

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String arr[] = str.split("\\\\"); // \?˜ë‚˜ ?°ê¸°?„í•´ \\\\ê°??¨ì•¼?œë‹¤!
            Node nowNode = root;
            for (String now : arr) {
                if (!nowNode.map.containsKey(now)) {
                    nowNode.map.put(now, new Node(now));
                }
                nowNode = nowNode.map.get(now);
            }
        }
        dfs(root, 0);

        System.out.println(sb);
    }

    public static void dfs(Node node, int depth) {
        List<String> nodeList = new ArrayList<>(node.map.keySet()); // treeMap???°ë©´ ?•ë ¬???˜ì? ?Šì•„???œë‹¤.
        // nodeList.sort((s1, s2) -> s1.compareTo(s2));

        for (int i = 0; i < nodeList.size(); i++) {
            String folderName = nodeList.get(i);
            Node next = node.map.get(folderName);

            for (int j = 0; j < depth; j++) {
                sb.append(" ");
            }
            sb.append(folderName + "\n");
            dfs(next, depth + 1);
        }
    }
}
