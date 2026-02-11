import java.io.*;
import java.util.*;

public class B14658{
    static StringBuilder sb;
    static int N,M,L,K;
    static int[][] star;
    static int ans;
    static final int INF = 1<<31;
    public static void main(String args[])throws IOException{
        readInput();
        System.out.println(sb);
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ans = 0;
        star = new int[K][2];
        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());

            star[k][0] = Integer.parseInt(st.nextToken()); //x
            star[k][1] = Integer.parseInt(st.nextToken()); //y
        }

        combination(0, new ArrayList<>(), 0);
        sb.append(ans);
    }

    public static void combination(int idx, List<Integer> list, int selCnt){
        if(selCnt == 2){
            int minX = INF;
            int minY = INF;
            for(int now : list){
                minX = Math.min(minX, star[now][0]);
                minY = Math.min(minY, star[now][1]);
            }

            int count = find(minX, minY); // 별 카운트
            ans = Math.max(count, ans);
            return;
        }
        if(idx == K) return;

        list.add(idx);
        combination(idx+1, list, selCnt+1);
        
        list.remove(list.size()-1);
        combination(idx+1, list, selCnt);
        
    }

    static int find(int x, int y){
        int count = 0;
        for(int i=0; i<K; i++){
            int sx = star[i][0];
            int sy = star[i][1];

            if(x<= sx && sx <= x+L && y <= sy && sy <= y+L) count++;
        }

        return count;
    }
}
