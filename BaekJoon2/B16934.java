import java.io.*;
import java.util.*;

public class B16934 { // 16934
    static StringBuilder sb;

    static class TrieNode{
        Map<Character, TrieNode> map;
        int count;
        public TrieNode(){
            map = new HashMap<>();
            count = 0;
        }
    }

    static class Trie{
        TrieNode trie;
        public Trie(){
            trie = new TrieNode();
        }

        public void insert(String str){
            TrieNode now = trie;
            boolean notContainFirstCheck = false;

            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);

                //now.map.computeIfAbsent(c, k -> new TrieNode()); // putIfAbsent 보다 메모리측면에???�득

                if(!notContainFirstCheck){
                    sb.append(c);
                }
                if(!now.map.containsKey(c)){
                    now.map.put(c, new TrieNode());
                    notContainFirstCheck = true;
                }
                now = now.map.get(c);
            }
            now.count++;

            if(!notContainFirstCheck){
                if(now.count > 1){
                    sb.append(now.count);
                }
            }
            sb.append("\n");
        }
    }
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();

        for(int i=0; i<N; i++){
            trie.insert(br.readLine());
        }
        System.out.println(sb);
    }
}
