import java.io.*;
import java.util.*;

public class S2383{
    static StringBuilder sb;
    static int arr[][];
    static int N;
    static List<Integer> list = new ArrayList<>();
    public static void main(String args[])throws IOException{
        readInput();
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            solve();
        }
        
    }

    public static void solve(){

    }
}
