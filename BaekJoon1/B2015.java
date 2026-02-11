import java.io.*;
import java.util.*;

public class B2015{
    //static StringBuilder sb;
    static Long N,K;

    public static void main(String args[])throws IOException{
        readInput();
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        HashMap<Long, Long> map = new HashMap<>();
        long total = 0;
        int ans = 0;
        map.put(0L, 1L);
        for(int i=1; i<=N; i++){
            total += Long.parseLong(st.nextToken());

            long findNumCnt = map.getOrDefault(total - K, 0L);
            ans += findNumCnt;

            map.put(total, findNumCnt +1);
        }

        System.out.println(ans);
    }
}
