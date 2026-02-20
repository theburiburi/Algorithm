import java.io.*;
import java.util.*;

public class B17180{
    static StringBuilder sb;
    public static void main(String args[])throws IOException{
        inputFile();
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String str1 = br.readLine();
        String str2 = br.readLine();
        
        int dp[][] = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = Math.abs(str1.charAt(0) - str2.charAt(0));
        for(int i=1; i<N; i++){
            dp[i][0] = dp[i-1][0] + Math.abs(str1.charAt(i) - str2.charAt(0));
        }

        for(int i=1; i<M; i++){
            dp[0][i] = dp[0][i-1] + Math.abs(str1.charAt(0) - str2.charAt(i));
        }

        for(int i=1; i<N; i++){
            for(int j=1; j<M; j++){
                int minNum = Math.min(Math.min(dp[i][j-1] ,dp [i-1][j]), dp[i-1][j-1]);
                dp[i][j] = minNum+Math.abs(str1.charAt(i) - str2.charAt(j));
            }
        }

        System.out.println(dp[N-1][M-1]);
    }
}
