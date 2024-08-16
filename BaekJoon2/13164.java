import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{ //13164 그리디
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int taller[] = new int[N];
        int diff[] = new int[N-1];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            taller[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N-1; i++){
            diff[i] = taller[i+1] - taller[i];
        }
        Arrays.sort(diff);
        int ans = 0;

        for(int i=0; i<N-K; i++){
            ans += diff[i];
        }
        System.out.println(ans);
    }
}