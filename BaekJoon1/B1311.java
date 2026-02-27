import java.io.*;
import java.util.*;

public class B1311{
    static StringBuilder sb;
    static int N, arr[][], dp[][];
    static int INF = 1_000_000;
    public static void main(String args[])throws IOException{
        inputFile();
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][1<<N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][1<<N];
        for(int i=0; i<N; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(solution(0,0));
    }

    public static int solution(int person, int mask){
        if(person == N) return 0;

        if(dp[person][mask] != -1) return dp[person][mask];

        int res = INF;
        for(int i=0; i<N; i++){
            if((mask & 1 <<i) == 0){
                res = Math.min(res, solution(person+1, mask | (1<<i)) + arr[person][i]);
            }
        }

        return dp[person][mask] = res;
    }
}
