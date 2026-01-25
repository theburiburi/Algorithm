import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P_6443{ //6443 문자??백트?�킹
    static int N;
    static int[] count;
    static char[] ch;
    static int chLen;
    static StringBuilder sb;
    static Stack<Character> stack;
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            count = new int[26];
            ch = br.readLine().toCharArray();
            for(char c : ch){
                count[c-'a']++;
            }
            chLen = ch.length;
            stack = new Stack<>();
            sb = new StringBuilder();
            dfs(0);
            System.out.print(sb.toString());
        }
    }
    static void dfs(int depth){
        if(depth == chLen){
            for(char temp : stack){
                sb.append(temp);
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<26; i++){
            if(count[i] > 0){
                count[i]--;
                stack.add((char)(i + 'a'));
                dfs(depth+1);
                stack.pop();
                count[i]++;
            }
        }
    }
}
