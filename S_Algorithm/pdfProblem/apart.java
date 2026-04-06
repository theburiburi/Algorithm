package pdfProblem;
import java.io.*;
import java.util.*;

public class apart{
    static StringBuilder sb;
    public static void main(String args[])throws IOException{
        readInput();
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int dp[][] = new int[N+1][2];
        dp[1][0] = 1; // 노랑
        dp[1][1] = 1; // 파랑
        for(int i=2; i<=N; i++){
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0]; 
        }

        System.out.println(dp[N][0] + dp[N][1]);
    }
}
//노노노 노파노 파노노 파노파 노노파