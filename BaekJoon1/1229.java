import java.io.*;
import java.util.*;

public class Main { //1229
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        int dp[] = new int[N+1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int now = 1;
        int dNow = 5;

        List<Integer> list = new ArrayList<>();
        list.add(now);
        for(int i=1; i<N+1; i++){
            if( i == now + dNow){
                list.add(now + dNow);
                now += dNow;
                dNow += 4;
            }
            for(int j=0; j<list.size(); j++){
                if(i >= list.get(j)){
                    dp[i] = Math.min(dp[i], dp[i-list.get(j)]+1);
                }
            }

        }
        System.out.println(dp[N]);
    }
}
