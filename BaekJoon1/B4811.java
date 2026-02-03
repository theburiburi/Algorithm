import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// **********?¤ì‹œ?€ê¸?*********
public class B4811{ //4811 DP 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long dp[] = new long[31];

        dp[0] = 1; //
        dp[1] = 1; //WH 
        dp[2] = 2; //WHWH or WWHH
        //dp[3] = 5;//WWWHHH or //WWHWHH// or WWHHWH or WHWWHH or WHWHWH
        //dp[4] = 14; //WWWWHHHH or WWWHWHHH or WWWHHWHH or WWWHHHWH or WWHWWHHH WWHWHWHH WWHWHHWH WWHHWWHH
                //WWHHWHWH WHWWWHHH WHWWHWHH WHWWHHWH WHWHWWHH WHWHWHWH
                // dp[3] = dp[0] * dp[2] + dp[1]*dp[1] + dp[2]*dp[0]
                // dp[4] = dp[0]*dp[3] + dp[1]*dp[2] + dp[2]*dp[1] + dp[3]*dp[0]
        for(int i=3; i<31; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
