import java.io.*;
import java.util.*;

public class S3421_2 {
    static int ans;
    static int N, M;
    static int badMask[];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            badMask = new int[N+1];
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());

                badMask[left] |= (1 << right-1);
                badMask[right] |= (1 << left-1);
            }

            ans = 0;
            dfs(1, 0);
            sb.append("#"+t+" "+ ans+"\n");
        }
        System.out.println(sb);
    }

    static void dfs(int idx, int curMask){
        if(idx > N){
            ans++;
            return;
        }

        dfs(idx+1, curMask);

        if((curMask & badMask[idx]) == 0){
            dfs(idx+1, curMask | 1 << idx-1);
        }
    }
}
