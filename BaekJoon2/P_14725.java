import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class P_14725{ // 14725 문자??trie
    static int N;
    static ArrayList<String> tree[];
    static StringBuilder sb;
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Trie root = new Trie();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            Trie total = root;
            for(int j=0; j<K; j++){
                String next = st.nextToken();
                if(!total.childs.containsKey(next)){
                    total.childs.put(next, new Trie());
                }
                total = total.childs.get(next);
            }
        }
        printTrie(root, "");
        System.out.println(sb.toString());
    }
    public static void printTrie(Trie root, String sentence){
        Object key[] = root.childs.keySet().toArray();
        Arrays.sort(key);
        for(Object temp : key){
            sb.append(sentence).append(temp).append("\n");
            printTrie(root.childs.get(temp), sentence+"--");
        }
    }
    static class Trie{
        HashMap<String, Trie> childs = new HashMap<>();
    }
}
