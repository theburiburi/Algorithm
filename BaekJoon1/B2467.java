import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
public class B2467{ // 완전탐색
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] liquid = new int[N];

        //StringTokenizer st = new StringTokenizer(br.readLine());
        String[] inputToken = br.readLine().split(" ");
        for (int i=0; i<N; i++){
            //iquid[i] = Integer.parseInt(st.nextToken());
            liquid[i] = Integer.parseInt(inputToken[i]); // ?�바 11 ?�후 좋�? 방법
        }
        int left = 0;
        int right = N-1;
        int acid = Integer.MAX_VALUE;
        int sign = 2;
        int[] ans = {0, 0};
        while(left < right){
            int plus = liquid[left] + liquid[right];

            if (plus < 0) {
                sign = -1;
                plus *= -1;
            }
            else sign = 1;

            if (plus < acid) {
                acid = plus;
                ans[0] = liquid[left];
                ans[1] = liquid[right];
            }

            if (sign == 1) right--;
            else if (sign == -1) left++;
        }

        System.out.println(ans[0] + " " + ans[1]);
    }
}
