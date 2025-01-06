import java.io.*;
import java.util.*;

public class Main { //3109 그래프
    static int dx[] = {1,1,1};
    static int dy[] = {-1,0,1};
    static int R,C;

    static boolean visited[][];
    static char arr[][];

    static int ans = 0;
    static boolean flag;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[R][C];
        arr = new char[R][C];
        for(int i = 0; i<R; i++){
            String temp = br.readLine();
            for(int j=0; j<C; j++){
                arr[i][j] = temp.charAt(j);
            }
        }

        for(int i=0; i<R; i++){
            flag = false;
            dfs(i,0);
        }
        System.out.println(ans);
    }
    static void dfs(int r, int c){
        if(c==C-1) {
            ans++;
            flag = true;
            visited[r][c] = true;
            return;
        }
        for(int i=0; i<3; i++){
            int newR = r+dy[i];
            int newC = c+dx[i];
            if(check(newR,newC) && !visited[newR][newC] && arr[newR][newC] == '.'){
                dfs(newR,newC);
                visited[r][c] = true;
                if(flag){
                    return;
                }
            }
        }
    }

    static boolean check(int r, int c){
        if (r<0 || r>=R || c<0 || c>=C){
            return false;
        }
        return true;
    }
}
