import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class Main{
    static TreeSet<String> set;
    static StringBuilder sb;
    static List<int []> AL;
    static boolean[] visited;
    static String sentence;
    static int senLen;
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sentence = br.readLine();
        Stack<Integer> stack = new Stack<>();
        AL = new ArrayList<>();
        set = new TreeSet<>();
        sb = new StringBuilder();

        senLen = sentence.length();
        visited = new boolean[senLen];
        for(int i=0; i<senLen; i++){
            if (sentence.charAt(i) == '('){
                stack.add(i);
            }
            else if(sentence.charAt(i) == ')'){
                AL.add(new int[] {stack.pop(), i});
            }
        }

        dfs(0);

        for(String temp : set){
            sb.append(temp+"\n");
        } // set.stream().forEach(ans -> sb.append(ans).append("\n"));
        System.out.println(sb.toString());
    }
    static void dfs(int index){
        if(index == AL.size()){
            StringBuilder senBuilder = new StringBuilder();
            for (int i=0; i<senLen; i++){
                if(!visited[i]){
                    senBuilder.append(sentence.charAt(i));
                }
            }
            String sen = senBuilder.toString();
            if(!sen.equals(sentence)){
                set.add(sen);
            }
            return;
        }

        visited[AL.get(index)[0]] = true;
        visited[AL.get(index)[1]] = true;
        dfs(index+1);
        visited[AL.get(index)[0]] = false;
        visited[AL.get(index)[1]] = false;
        dfs(index+1);
    }
}