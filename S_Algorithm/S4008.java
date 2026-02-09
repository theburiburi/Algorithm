import java.io.*;
import java.util.*;

public class S4008{
    static int T;
    static int N;
    static int maxVal, minVal;
    static int[] num, operation;
    public static void main(String args[])throws IOException{
        readInput();
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());

            maxVal = Integer.MIN_VALUE;
            minVal = Integer.MAX_VALUE;
            operation = new int[4];
            num = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++){
                operation[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }

            dfs(1, num[0]);
            sb.append("#"+t+ " "+ (maxVal - minVal)+"\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int depth, int sum){
        if(depth == N){
            maxVal = Math.max(maxVal, sum);
            minVal = Math.min(minVal, sum);
            return;
        }
        
        for(int i=0; i<4; i++){
            if(operation[i] > 0){
                int next = sum;
                switch (i) {
                    case 0:
                        next += num[depth];
                        break;
                    case 1:
                        next -= num[depth];
                        break;

                    case 2:
                        next *= num[depth];
                        break;
                    default:
                        next /= num[depth];
                        break;
                }
                operation[i]--;
                dfs(depth+1, next);
                operation[i]++;
            }
        }
    }
}
