import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1107{ //1107 ?ÑÏ†Ñ?êÏÉâ
    static int M, N, answer;
    static boolean[] check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        check = new boolean[10];
        
        if(M!=0){
            String str[] = br.readLine().split(" ");
            for (int i=0; i<M; i++){
                int temp = Integer.parseInt(str[i]);
                check[temp] = true;
            }
        }

        answer = Math.abs(N-100);
        dfs(0 ,0);
        System.out.println(answer);
    }
    public static void dfs(int num, int depth){
        if(depth == 6){
            return;
        }
        num *= 10;
        for (int i=0; i<10; i++){
            if(!check[i]){
                answer = Math.min(answer, Math.abs(N - (num+i)) + depth + 1);
                dfs(num+i, depth+1);
            }
        }
    }
}
