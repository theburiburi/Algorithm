import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B16437 {

    static List<Integer> list[];
    static long[] sheepCnt; 

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        list = new ArrayList[N + 1];
        sheepCnt = new long[N + 1];
        
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            long count = Long.parseLong(st.nextToken());
            int connect = Integer.parseInt(st.nextToken());

            if (type.equals("W")) count = -count; 
            sheepCnt[i] = count;
            list[connect].add(i);
        }
        System.out.println(dfs(1));
    }

    public static long dfs(int now) {
        long sum = 0;

        for(int next : list[now]){
            sum += dfs(next);
        }
        sum += sheepCnt[now];

        return Math.max(0, sum);
    }
}