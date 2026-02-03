import java.io.*;
import java.util.*;

public class B2631 {//2631 dp
    static int N;
    static int children[], dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        children = new int[N];
        dp = new int[N];
        for(int i=0; i<N; i++){
            children[i] = Integer.parseInt(br.readLine());
        }
        
        int max = 0;
        for(int i=0; i<N; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(children[i] > children[j] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                    max = Math.max(max, dp[i]);
                }
            }
        }

        System.out.println(N-max);
    }
}
