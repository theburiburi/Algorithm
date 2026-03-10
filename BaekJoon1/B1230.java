import java.io.*;
import java.util.*;

public class B1230{
    static StringBuilder sb;
    static String str1, str2;
    static final int INF = 10000;
    public static void main(String args[])throws IOException{
        inputFile();
        solve();
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();

        str1 = br.readLine();
        str2 = br.readLine();
    }

    public static void solve(){
        int n = str1.length();
        int m = str2.length();
        int dp[][][] = new int[n+1][m+1][2];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                dp[i][j][0] = INF;
                dp[i][j][1] = INF;
            }
        }
        dp[0][0][0] = 0;

        for(int i=0; i<=n; i++){
            for(int j=1; j<=m; j++){
                dp[i][j][1] = Math.min(dp[i][j-1][0]+1, dp[i][j-1][1]);

                if(i>0 && str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j][0] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]);
                }
            }
        }
        int ans = Math.min(dp[n][m][0], dp[n][m][1]);
        System.out.println(ans == INF ? -1 : ans);
    }
}
