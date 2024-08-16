import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// **********다시풀기**********
public class Main{//15989 DP
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        int dp[] = new int[T+1];

        dp[1] = 1; //1
        dp[2] = 2; //2 11
        dp[3] = 3; //3 21 111
        //dp4 = 4 // 31 22 211 1111
        //dp5 = 5 // 32 311 221 21111 11111
        //dp6 = 7 33 321 3111 222 2211 21111 1111111
        //dp7 = 8 331 322 3211 31111 2221 22111 211111 1111111
        //dp8 = 10 332 3311 3221 32111 311111 2222 22211 221111 2111111 1111111
        //dp9 =    333 3321 
        for(int i=4; i<=T; i++){
            if (i % 3 == 0)
            dp[i] = 
        }

        for(int i=0; i<T; i++){
            int temp = Integer.parseInt(br.readLine());
            sb.append(dp[temp]).append('\n');
        }
        System.out.println(sb.toString());
        
    }
}