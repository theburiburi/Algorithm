import java.io.*;
 
public class Main {
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        char[] str3 = br.readLine().toCharArray();

        int length_1 = str1.length;
        int length_2 = str2.length;
        int length_3 = str3.length;

        dp = new int[length_1 + 1][length_2 + 1][length_3 + 1];

        for(int i = 1; i <= length_1; i++) {
            for(int j = 1; j <= length_2; j++) {
                for (int k = 1; k <= length_3; k++) {
                    // (i-1)번째 문자 == (j-1)번째 문자 == (k-1)번째 문자
                    if(str1[i - 1] == str2[j - 1] && str2[j - 1] == str3[k - 1]) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } 
                    else {
                        //이전 열(i-1)과 이전 행(j-1), (k-1)의 값 중 큰 것으로 갱신
                        dp[i][j][k] = Math.max(dp[i - 1][j][k],
                                Math.max(dp[i][j - 1][k], dp[i][j][k - 1])
                        );
                    }
                    
                }
            }
        }
        System.out.println(dp[length_1][length_2][length_3]);
    }
}