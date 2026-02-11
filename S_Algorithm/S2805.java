import java.io.*;
import java.util.*;

public class S2805{
    static StringBuilder sb;
    public static void main(String args[])throws IOException{
        readInput();
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            int total = 0;
            int idx = N/2;
            int count = 1;

            boolean decrease = false;
            for(int k=0; k<N; k++){
                String arr = br.readLine();
                if(!decrease){
                    for(int i = idx; i<idx+count; i++){
                        total += arr.charAt(i)-'0';
                    }
                    
                    if(k == N/2) {
                        decrease=true;
                        count -= 2;
                        idx += 1;
                        continue;
                    }
                    count += 2;
                    idx -= 1;
                }
                else{
                    for(int i=idx; i<idx+count; i++){
                        total += arr.charAt(i) -'0';
                    }
                    count -=2;
                    idx+=1;
                }
            }
            sb.append("#"+t+ " " + total+"\n");
        }
        System.out.println(sb);
    }
}
