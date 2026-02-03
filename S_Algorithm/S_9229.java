import java.io.*;
import java.util.*;

public class S_9229 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int arr[] = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int ans = -1;
            int left = 0;
            int right = N-1;
            while(left < right){
                int sum = arr[left] + arr[right];
                if(sum > M){
                    right--;
                }
                else{
                    ans = Math.max(ans, sum);
                    left++;
                }
            }
            
            sb.append("#").append(t+ " ").append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
