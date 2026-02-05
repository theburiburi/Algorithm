import java.io.*;
import java.util.*;

public class S5215 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int dp[] = new int[L+1];
            for(int i=0;i<N; i++){
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int kcal = Integer.parseInt(st.nextToken());

                for(int j=L; j-kcal>=0; j--){
                    dp[j] = Math.max(dp[j], dp[j-kcal] + score);
                }
            }

            sb.append("#"+t+ " "+dp[L]+"\n");
        }
        
        System.out.println(sb);
    }
}
