import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class P_1327 {//1327 ?´ì‹œë§? ê·¸ëž˜??
    static int N, K, S;
    static String ans_str, ch_str;
    public static class Node{
        String str;
        int count;
        public Node(String str, int count){
            this.str = str;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        char ch[] = br.readLine().replace(" ", "").toCharArray();
        char ans[] = Arrays.copyOf(ch, N);
        Arrays.sort(ans);

        ch_str = new String(ch);
        ans_str = new String(ans);

        System.out.println(bfs());
    }
    public static int bfs(){
        Queue<Node> que = new LinkedList<>();
        Set<String> set = new HashSet<>();

        que.add(new Node(ch_str, 0));
        set.add(ch_str);

        while(!que.isEmpty()){
            Node temp = que.poll();

            if(ans_str.equals(temp.str)){
                return temp.count;
            }
        
            for (int i = 0; i <= N - K; i++) {
                String reversedStr = revStr(temp.str, i, i + K);

                if (!set.contains(reversedStr)) {
                    set.add(reversedStr);  
                    que.add(new Node(reversedStr, temp.count + 1));
                }
            }
        }
        return -1;
    }
    public static String revStr(String str, int start, int end){
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, start));

        StringBuilder sbReverse = new StringBuilder();
        sbReverse.append(str.substring(start, end));
        sbReverse.reverse();
        sb.append(sbReverse.toString());

        sb.append(str.substring(end, N));
        return sb.toString();
    }
}
