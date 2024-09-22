import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 11403{ //플로이드 와샬
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int[N][N];
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k=0; k<N; k++){
            for (int i=0; i<N; i++){
                for (int j=0; j<N; j++){
                    if(arr[i][k] == 1 && arr[k][j] == 1) arr[i][j] = 1; 
                }
            }
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                sb.append(arr[i][j] + " "); 
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}