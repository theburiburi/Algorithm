import java.io.*;
import java.util.*;

public class B16565{
    static StringBuilder sb;
    static int[][] C;
    static final int MOD = 10007;
    public static void main(String args[])throws IOException{
        inputFile();
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        C = new int[53][53];
        makeC();

        int ans = 0;
        for(int i=1; i*4 <= N; i++){
            int temp = (C[13][i] * C[52-i*4][N-4*i]) % MOD;

            if(i%2 == 1){
                ans = (ans+temp)%MOD;
            }
            else{
                ans = (ans-temp+MOD)%MOD;
            }
        }

        System.out.println(ans);
    
    }

    public static void makeC(){
        for(int i=0; i<=52; i++){
            C[i][0] = 1;
            for(int j=1; j<=i; j++){
                C[i][j] = (C[i-1][j-1] + C[i-1][j])%MOD;
            }
        }
    }
}
