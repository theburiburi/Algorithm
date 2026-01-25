import java.io.*;
import java.util.*;

public class P_26607 { //26607 dp
    static int n, k, x;
    static int ans = 0;
    static boolean dp[][];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int people[] = new int[n];
        dp = new boolean[k+1][k*x+1];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            people[i] = Integer.parseInt(st.nextToken());
            st.nextToken();
            knapsack(people[i]);
        }
        for(int i=0; i<=k*x; i++){
            if(dp[k][i]){
                ans = Math.max(ans, i*(k*x-i));
            }
        }
        System.out.println(ans);
    }
    static void knapsack(int a){
        for(int i=k-1; i>0; i--){
            for(int j=k*x-a; j>=0; j--){
                dp[i+1][j+a] = dp[i+1][j+a] || dp[i][j];
            }
        }
        dp[1][a] = true;
    }
}

