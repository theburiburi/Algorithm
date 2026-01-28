import java.io.*;
import java.util.*;

public class P_11049 {
    static class Node{
        int left;
        int right;
        public Node(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
    static int answer = Integer.MAX_VALUE;
    static boolean visited[];
    static int T;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        Node node[] = new Node[T];
        visited = new boolean[T];
        int dp[][] = new int[T][T];
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            node[t] = new Node(left, right);
        }
        
        for(int i=0; i<T; i++){
            for(int j=i+1; j<T; j++){
                if(i==j) dp[i][j] = Integer.MAX_VALUE;
                Node left = node[i];
                Node right = node[j];
                dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + left.left * right.right *);
            }
        }
    }
}

