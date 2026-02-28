import java.io.*;
import java.util.*;

public class B1509 {
    static String str;
    static int len;
    static boolean[][] isPal;
    static int[] dp;

    public static void main(String args[]) throws IOException {
        inputFile();
        solution();
    }

    static void inputFile() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        len = str.length();

        isPal = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            isPal[i][i] = true;
        }

        for (int i = 0; i < len - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                isPal[i][i + 1] = true;
            }
        }

        for (int i = 3; i <= len; i++) {
            for (int left = 0; left <= len - i; left++) {
                int right = left + i - 1;
                if (str.charAt(left) == str.charAt(right) && isPal[left + 1][right - 1]) {
                    isPal[left][right] = true;
                }
            }
        }
    }

    static void solution() {
        dp = new int[len];
        for(int i=0; i<len; i++){
            dp[i] = i+1;

            for(int j=0; j<=i; j++){
                if(isPal[j][i]){
                    if(j==0){
                        dp[i] = 1;
                    }
                    else{
                        dp[i] = Math.min(dp[i], dp[j-1]+1);
                    }
                }
            }
        }
        System.out.println(dp[len-1]);
    }
}