import java.io.*;
import java.util.*;

public class P_14002 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[N];
        int arr[] = new int[N];
        int parent[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] =Integer.parseInt(st.nextToken());
        }

        
        int maxLen = 0;
        int lastIdx = 0;
        for(int i=0;i<N; i++){
            dp[i] = 1;
            parent[i] = -1;
            for (int j=0; j<i; j++){
                if(arr[j] < arr[i] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j] +1;
                    parent[i] = j;
                }
            }
            if(dp[i] > maxLen){
                maxLen = dp[i];
                lastIdx = i;
            }
        }

        sb.append(maxLen+"\n");

        Stack<Integer> stack = new Stack<>();
        while(lastIdx != -1){
            stack.push(arr[lastIdx]);
            lastIdx = parent[lastIdx];
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }
        System.out.println(sb);
    }
}
