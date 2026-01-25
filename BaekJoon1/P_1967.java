import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_1967{ //1967
    static ArrayList<Integer[]> tree[];
    static int N;
    static int sum = 0;
    static boolean check[];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        tree = new ArrayList[N+1];
        for (int i=1; i<=N; i++){
            tree[i] = new ArrayList<>();
        }
        for (int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree[parent].add(new Integer[]{child, weight});
            tree[child].add(new Integer[]{parent, weight});
        }
        for(int i=1; i<N; i++){
            check = new boolean[N+1];
            dfs(i,0);
        }
        System.out.println(sum);
    }
    static void dfs(int start, int total){
        check[start] = true;
        sum = Math.max(sum, total);
        for(Integer temp[] : tree[start]){
            int next = temp[0];
            int cost = temp[1];
            if(!check[next]){
                dfs(next, total+cost);
            }
        }
    }
}
