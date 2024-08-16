import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;
//import java.util.Collections;
public class Main{ //2212 그리디
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int sensor[] = new int[N];
        int diff[] = new int[N-1];
        //Integer sensor[] = new Integer[N]; //Arrays.sort(sensor, Collections.reverseOrder()); 내림차순

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            sensor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensor);

        for(int i=0; i<N-1; i++){
            diff[i] = sensor[i+1] - sensor[i];
        }
        Arrays.sort(diff);

        int answer = 0;
        for(int i=0; i<N-K; i++){
            answer += diff[i];
        }
        System.out.println(answer);
    }
}