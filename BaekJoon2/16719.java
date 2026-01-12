import java.io.*;
import java.util.*;

public class 16719 { //16719
    static int N;
    static String str = "";
    static boolean check[];
    static StringBuilder sb;
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        str = br.readLine();
        N = str.length();
        check = new boolean[N];

        dfs(0, N-1);
        System.out.println(sb);
    }
    public static void dfs(int leftIdx, int rightIdx){
        if(leftIdx > rightIdx) return;

        int next = leftIdx;
        for(int j = leftIdx; j<=rightIdx; j++){
            if(str.charAt(next) > str.charAt(j)){
                next = j;
            }
        }
        
        check[next] = true;

        for(int i=0; i<N; i++){
            if(check[i]) sb.append(str.charAt(i));
        }
        sb.append("\n");
        

        dfs(next+1, rightIdx);
        dfs(leftIdx, next-1);
    }
}
