import java.io.*;
import java.util.*;

public class 2138 { //2138 그리디
    static int end[];
    static int N;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int start[] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        end = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        int copy[] = Arrays.copyOf(start, N);
        copy[0] = 1 - copy[0];
        copy[1] = 1 - copy[1];

        int ans1 = solve(start);
        int ans2 = solve(copy);
        if(ans2 != -1) ans2++;

        if(ans1 == -1) System.out.println(ans2);
        else if(ans2 == -1) System.out.println(ans1);
        else System.out.println(Math.min(ans1, ans2));
        
    }
    static int solve(int[] arr){
        int cnt = 0;
    
        for(int i=0; i<N-1; i++){
            if(arr[i] != end[i]){
                cnt++;
                arr[i] = 1 - arr[i];
                arr[i+1] = 1 - arr[i+1];
                if(i != N-2){
                    arr[i+2] = 1 - arr[i+2];
                }
            }
        }

        return arr[N-1] == end[N-1] ? cnt : -1;
    }
}
