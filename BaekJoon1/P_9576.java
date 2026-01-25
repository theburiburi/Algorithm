import java.io.*;
import java.util.*;

public class P_9576 { //9576 그리??
    static int N,M;
    static class Node implements Comparable<Node>{
        int mini;
        int maxi;
        public Node(int mini, int maxi){
            this.mini = mini;
            this.maxi = maxi;
        }

        @Override
        public int compareTo(Node o){
            if(maxi == o.maxi){
                return mini - o.mini;
            }
            return maxi - o.maxi;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int k=0; k<T; k++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            Node arr[] = new Node[M];
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int mini = Integer.parseInt(st.nextToken());
                int maxi = Integer.parseInt(st.nextToken());

                arr[i] = new Node(mini, maxi);
            }
            Arrays.sort(arr);

            int ans = 0;
            boolean check[] = new boolean[N];
            for(int i=0; i<M; i++){
                int mini = arr[i].mini;
                int maxi = arr[i].maxi;

                for(int j=mini-1; j<maxi; j++){
                    if(!check[j]){
                        check[j] = true;
                        ans++;
                        break;
                    }
                }
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);

    }
}

