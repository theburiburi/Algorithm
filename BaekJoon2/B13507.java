import java.io.*;
import java.util.*;

public class B13507{
    static StringBuilder sb;
    static class Node{
        Map<Character, Node> map = new HashMap<>();
    }
    static int ans;
    public static void main(String args[])throws IOException{
        inputFile();
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();

        String str = br.readLine();
        int alphabet[] = new int[128];
        
        String alCnt = br.readLine();
        for(int i=0; i<26; i++){
            if(alCnt.charAt(i) == '1') {
                alphabet['a'+i] = 1;
            }
        }
        int K = Integer.parseInt(br.readLine());

        Node trie = new Node();
        for(int left=0; left<str.length(); left++){
            Node now = trie;
            int size = 0;
            int right = left;
            while(right<str.length()){
                if(alphabet[str.charAt(right++)]==0){
                    size++;
                    if(size > K) {
                        break;
                    }
                }
                //right++;
            }
            for(int idx = left; idx < right; idx++){
                now.map.computeIfAbsent(str.charAt(idx), k-> new Node());
                now = now.map.get(str.charAt(idx));
            }
        }
        ans = 0;
        dfs(trie);
        System.out.println(ans);
    }
    static void dfs(Node now){
        if(now.map == null) return;
        
        for(char c : now.map.keySet()){
            ans++;
            dfs(now.map.get(c));
        }
    }
}
