import java.io.*;
import java.util.*;

public class Main { //1135 dp, 그리디
    static List<Integer> tree[];
    static int dp[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        tree = new ArrayList[N];
        dp = new int[N];
        int root = 0;

        for(int i=0; i<N; i++){
            tree[i] = new ArrayList<>();
            int temp = Integer.parseInt(st.nextToken());
            if (temp != -1){
                tree[temp].add(i);
            }
            else{
                root = i;
            }
        }
        int ans = solve(root);
        System.out.println(ans);
    }
    
    static public int solve(int now){
        for(int next : tree[now]){
            dp[next] = 1 + solve(next);
        }
        tree[now].sort((s1,s2)-> dp[s2]-dp[s1]);
        int num = 0;
        for(int i=0; i<tree[now].size(); i++){
            int next = tree[now].get(i);
            dp[next] += i;
            num = Math.max(num, dp[next]);
        }
        return num;
    }
}
