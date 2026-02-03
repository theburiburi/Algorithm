import java.io.*;
import java.util.*;

public class B1443 { //1443 백트?�킹
    static Long ans = -1L;
    static int D, P;
    static boolean check = false;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        D = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        dfs(1, P, 9);

        System.out.println(ans);
    }
    public static void dfs(int num, int times, int start){// start -> 문제 ?�결(조합)!!!
        int currentDigit = (num+"").length(); // ?�로 ?�게 ??!!
        if(currentDigit > D) return;
        if (times == 0){
            ans = Math.max(ans, num);
        }
        for(int i=start; i>1; i--){
            dfs(num*i, times-1, i);
        }
    }
}
