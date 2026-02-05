import java.io.*;
import java.util.*;

public class S8275 {
    static class Node{
        int l;
        int r;
        int s;
        public Node(int l, int r, int s){
            this.l = l;
            this.r = r;
            this.s = s;
        }
    }
    static Node condition[];
    static int cage[];
    static int answer[];
    static int ans;
    static int N, X, M;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            cage = new int[N];
            condition = new Node[M];
            ans = -1;
            answer = new int[N];

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                condition[i] = new Node(l, r, s);
            }

            solution(0, cage);
            sb.append("#"+t+ " ");
            if(ans == -1){
                sb.append("-1");
            }
            else{
                for(int i=0; i<N; i++){
                    sb.append(answer[i] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void solution(int position, int cage[]){
        if(position == N) {
            if(check(cage)){
                int sum = 0;
                for(int i=0; i<N; i++){
                    sum += cage[i];
                }
                if (sum > ans){
                    ans = sum;
                    for(int i=0; i<N; i++){
                        answer[i] = cage[i];
                    }
                }
            }
            return;
        } 
        for(int i=0; i<=X; i++){
            cage[position] = i;
            solution(position+1, cage);
        }
    }
    public static boolean check(int cage[]){
        for(int i=0; i<M; i++){
            Node now = condition[i];

            int sum = 0;
            for(int j=now.l-1; j<now.r; j++){
                sum += cage[j];
            }
            if(sum != now.s) return false;
        }
        return true;
    }
}
