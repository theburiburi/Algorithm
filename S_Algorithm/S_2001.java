import java.io.*;
import java.util.*;

public class S_2001 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int arr[][] = new int[N+1][N+1];
            for(int i=1; i<=N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int S[][] = new int[N+1][N+1];

            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1]+ arr[i][j];
                }
            }

            int max = 0;
            for(int i=M; i<=N; i++){
                for(int j=M; j<=N; j++){
                    max = Math.max(max, S[i][j] - S[i-M][j] - S[i][j-M]+ S[i-M][j-M]);
                }
            }
            sb.append("#"+t+" "+max+"\n");
        }
        System.out.println(sb);
    }
}
