import java.io.*;
import java.util.*;

public class B3178 {
    static int nodeCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<Character, Object> prefixTrie = new HashMap<>();
        Map<Character, Object> suffixTrie = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            insert(prefixTrie, word.substring(0, K));
            insert(suffixTrie, new StringBuilder(word.substring(K)).reverse().toString());
        }

        System.out.println(nodeCount);
    }
    
    static void insert(Map<Character, Object> root, String str) {
        Map<Character, Object> current = root;
        for (char c : str.toCharArray()) {
            if (!current.containsKey(c)) {
                current.put(c, new HashMap<Character, Object>());
                nodeCount++;
            }
            current = (Map<Character, Object>) current.get(c);
        }
    }
}