import java.io.*;
import java.util.*;

public class 19566 { //19566 해시
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int num[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
    
        long sum = 0;
        long ans = 0;
        Map<Long, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            sum += (long)num[i];
            long diff = (long)K*(i+1) - sum;

            if(diff == 0) ans++;
    
            int count = map.getOrDefault(diff, 0);
            ans += (long)count;
            map.put(diff, count+1);
        }
        System.out.println(ans);
    }
}