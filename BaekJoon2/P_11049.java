import java.io.*;
import java.util.*;

public class P_11049{
    static class Node{
        int left;
        int right;
        public Node(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Node node[] = new Node[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            node[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int dp[][] = new int[N][N];

        for(int cnt=1; cnt<N; cnt++){
            for(int i=0; i+cnt <N; i++){
                int j = i+cnt;
                dp[i][j] = Integer.MAX_VALUE;

                for(int k=i; k<j; k++){
                    int total = dp[i][k] + dp[k+1][j] + node[i].left * node[k].right * node[j].right;
                    dp[i][j] = Math.min(dp[i][j], total);
                }
            }
        }

        System.out.println(dp[0][N-1]);
    }
}