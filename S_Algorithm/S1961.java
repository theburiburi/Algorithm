import java.io.*;
import java.util.*;

public class S1961 {

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        

        for(int i=1; i<=T; i++){
            sb.append("#"+i+"\n");
            int N = Integer.parseInt(br.readLine());
            String arr[][] = new String[N][N];
            String answer[][] = new String[N][3];

            for(int j=0; j<N; j++){
                Arrays.fill(answer[j], "");
            }

            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<N; k++){
                    arr[j][k] = st.nextToken();
                }
            }

            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    answer[j][0] += arr[N-1-k][j]; //90
                    answer[j][1] += arr[N-1-j][N-1-k]; //180
                    answer[j][2] += arr[k][N-1-j]; //270
                }
            }
            for(int j=0; j<N; j++){
                for(int k=0; k<3; k++){
                    sb.append(answer[j][k] + " ");
                }
            sb.append("\n");
        }
        }


        System.out.println(sb.toString());
    }
}

