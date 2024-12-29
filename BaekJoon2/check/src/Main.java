import java.io.*;
import java.util.*;

public class Main {//
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int coin[] = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                coin[j] = Integer.parseInt(st.nextToken());
            }
            int prob = Integer.parseInt(br.readLine());
            int dp[] = new int[prob+1];

            dp[0] = 1;
            for(int j=0; j<coin.length; j++){
                for(int k=1; k<=prob; k++){
                    int temp = k - coin[j];
                    
                    if(temp >= 0){
                        dp[k] += dp[temp];
                    }
                }
            }
            sb.append(dp[prob]).append("\n");
        }
        System.out.println(sb);
    }
}
