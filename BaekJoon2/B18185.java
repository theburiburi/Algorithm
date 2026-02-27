import java.io.*;
import java.util.*;

public class B18185{
    static StringBuilder sb;
    static int N, arr[];
    public static void main(String args[])throws IOException{
        inputFile();
        solution();
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+2];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
    static void solution(){
        int ans = 0;
        for(int i=0; i<N; i++){
            if(arr[i] == 0) continue;

            if(arr[i+1] > arr[i+2]){
                int minCnt = Math.min(arr[i], Math.min(arr[i], arr[i+1] - arr[i+2]));
                ans+= minCnt * 5;
                for(int j=0;j<2; j++){
                    arr[i+j] -= minCnt;
                }

                minCnt = Math.min(arr[i], Math.min(arr[i+1], arr[i+2]));
                ans+= minCnt * 7;
                for(int j=0;j<3; j++){
                    arr[i+j] -= minCnt;
                }
            }
            else{
                int minCnt = Math.min(arr[i], Math.min(arr[i+1], arr[i+2]));

                ans+= minCnt * 7;
                for(int j=0;j<3; j++){
                    arr[i+j] -= minCnt;
                }
            }
            ans += arr[i] * 3;
            arr[i] = 0;
        }
        
        System.out.println(ans);
    }
}
