import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.StringBuilder;

public class S3260 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        java.lang.StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int t=1; t<=N; t++){
            sb.append("#"+t+" ");
            StringBuilder ans = new StringBuilder();

            String num[] = br.readLine().split(" ");
            String answer = "";
            int carry = 0;
            
            String bigNum;
            String smallNum;
            if(num[0].length() >= num[1].length()){
                bigNum = num[0];
                smallNum = num[1];
            }
            else{
                bigNum = num[1];
                smallNum = num[0];
            }

            int bigPosition = bigNum.length()-1;
            for(int i=smallNum.length()-1; i>=0; i--){
                int small = smallNum.charAt(i) - '0';
                int big = bigNum.charAt(bigPosition--) - '0';

                int currentNum = small+big + carry;
                carry = currentNum / 10;
                currentNum %= 10;
                ans.insert(0, currentNum);
            }

            for(int i= bigPosition; i>=0; i--){
                int currentNum = bigNum.charAt(i) -'0';
                if(carry != 0){
                    currentNum += carry;
                    carry = currentNum /10;
                    currentNum = currentNum % 10;
                }
                ans.insert(0, currentNum);
            }

            if(carry != 0){
                ans.insert(0, carry);
            }
            
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
