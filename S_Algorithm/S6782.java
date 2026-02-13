import java.io.*;
import java.util.*;

public class S6782{
    static StringBuilder sb;
    public static void main(String args[])throws IOException{
        readInput();
        System.out.println(sb);
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++){
            int ans = 0;
            long N = Long.parseLong(br.readLine());
            while(N != 2){
                long sqrtN = (long)Math.sqrt(N);
                if(sqrtN*sqrtN == N){
                    N = sqrtN;
                    ans++;
                }
                else{
                    long next = (sqrtN+1)*(sqrtN+1);
                    ans += (next-N);
                    N = next;
                }
            }
            
            sb.append("#"+t + " "+ ans+"\n");
        }
    }
}
