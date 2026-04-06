import java.io.*;
import java.util.*;

public class S1952_2{
    static StringBuilder sb;
    static final int INF = 130000;
    public static void main(String args[])throws IOException{
        inputFile();
        System.out.println(sb.toString());
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int price[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int plan[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int dp[] = new int[13];

            
            Arrays.fill(dp, INF);
            dp[0] = 0;
            dp[12] = price[3];
            dp[1] = price[0]*plan[0];
            for(int i=1; i<=12; i++){
                dp[i] = Math.min(dp[i], plan[i-1]*price[0]+dp[i-1]);
                dp[i] = Math.min(dp[i], price[1]+dp[i-1]);
                if(i >= 3){ 
                    dp[i] = Math.min(dp[i], dp[i-3]+price[2]);
                }
                else{
                    dp[i] = Math.min(dp[i], price[2]);
                }
            }
            sb.append("#"+t+ " ").append(dp[12]).append("\n");
        }
    }
}
