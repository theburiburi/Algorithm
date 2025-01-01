import java.io.*;
import java.util.*;

public class 5582 {//5582 String, dp
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sen1 = br.readLine();
        String sen2 = br.readLine();
        int dp[][] = new int[sen1.length()+1][sen2.length()+1];
        int answer = 0;
        for(int i=1; i<=sen1.length(); i++){
            for(int j=1; j<=sen2.length(); j++){
                if(sen1.charAt(i-1) == sen2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    answer = Math.max(dp[i][j], answer);
                }
            }
        }
        System.out.println(answer);
    }
}
