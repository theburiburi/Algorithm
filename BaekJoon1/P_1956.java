import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class P_1956{//1956 그래???�??
    static int V, E;
    static int arr[][];
    static final int INF = 200000000;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        arr = new int[V+1][V+1];
        for(int i=1; i<=V; i++){
            Arrays.fill(arr[i], INF);
        }

        for(int i=1; i<=E; i++){
            st = new StringTokenizer(br.readLine());
            int startNum = Integer.parseInt(st.nextToken());
            int endNum = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            arr[startNum][endNum] = cost;
        }
        System.out.println(wasshal());
        
    }
    static int wasshal(){
        for(int k=1; k<=V; k++){
            for (int i=1; i<=V; i++){
                for(int j=1; j<=V; j++){
                    if (arr[i][j] > arr[i][k] + arr[k][j]){
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int ans = INF;
        for (int i = 1; i <= V; i++) {
            ans = Math.min(ans, arr[i][i]);
        }
        return ans == INF ? -1 : ans;
    }
}
