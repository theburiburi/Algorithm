package pdfProblem;
import java.io.*;
import java.util.*;

public class stick{
    static StringBuilder sb;
    public static void main(String args[])throws IOException{
        readInput();
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());

        int dp[][] = new int[N+1][3];
        dp[1][0] = 1; // 노랑
        dp[1][1] = 1; // 파랑
        dp[1][2] = 0;
        dp[2][0] = 2;
        dp[2][1] = 2;
        dp[2][2] = 1;
        for(int i=3; i<=N; i++){
            dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2];
            dp[i][1] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2];
            dp[i][2] = dp[i-2][0] + dp[i-2][1] + dp[i-2][2]; 
        }

        System.out.println(dp[N][0] + dp[N][1] + dp[N][2]);
    }
}