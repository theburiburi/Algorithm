import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// **********다시풀기**********
public class Main{ //9095 DP
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        int num[] = new int[T];
        int dp[] = new int[T+1];

        dp[1] = 1; //1
        dp[2] = 2; //2 11
        dp[3] = 4; //3 21 12 111
        //dp4 = 7 // 31 13 22 211 121 112 1111

        for(int i=4; i<=T; i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        for(int i=0; i<T; i++){
            int temp = Integer.parseInt(br.readLine());
            sb.append(dp[num[i]]).append('\n');
        }
        System.out.println(sb.toString());
        
    }
}