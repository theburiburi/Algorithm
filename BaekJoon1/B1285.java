import java.io.*;
import java.util.*;

public class B1285 { //1285
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char arr[][] = new char[N][N];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine().toCharArray();
        }

        int ans = Integer.MAX_VALUE;
        for(int bit=0; bit < (1<<N); bit++){
            int sum = 0;
            for(int j=0; j<N; j++){
                int count = 0;
                for(int i=0; i<N; i++){
                    char temp = arr[i][j];
                    if((bit & (1<<i)) != 0){
                        temp = reverse(temp);
                    }
                    if(temp == 'T') count++;
                }
                sum += Math.min(count , N-count);
            }
            ans = Math.min(ans, sum);
        }    

        System.out.println(ans);
    }
    public static char reverse(char value){
        if (value == 'T') return 'H';
        return 'T';
    }
}

