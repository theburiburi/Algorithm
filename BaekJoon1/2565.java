import java.io.*;
import java.util.*;

public class 2565 {//2565 dp
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int[N][2];
        int dp[] = new int[N];
        int max = 0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (s1, s2)-> s1[0]-s2[0]);

        for(int i=0;i<N; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i][1] > arr[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(N-max); 
    }
}
