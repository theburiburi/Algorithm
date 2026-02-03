import java.io.*;
import java.util.*;

public class S1486 { // 1486 brute-force, subset
    static int N, B;
    static int height[];
    static int answer;
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            answer = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            height = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i< N; i++){
                height[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);

            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int idx, int sum){
        if(sum >= B){
            answer = Integer.min(answer, sum - B);
            return;
        }
        
        if(idx == N) return;

        dfs(idx+1, sum+height[idx]);
        dfs(idx+1, sum);
    }
}

