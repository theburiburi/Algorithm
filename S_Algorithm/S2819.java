import java.io.*;
import java.util.*;

public class S2819{
    static StringBuilder sb;
    static char arr[][], ans[];
    static Set<String> set;

    static int dy[] = {1, -1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    public static void main(String args[])throws IOException{
        readInput();
        System.out.println(sb.toString());
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            arr = new char[4][4];
            set = new HashSet<>();
            for(int i=0; i<4; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<4; j++){
                    arr[i][j] = st.nextToken().charAt(0);
                }
            }
            solve();
            sb.append("#").append(t).append(" ").append(set.size()).append("\n");
        }
    }

    public static void solve(){
        ans = new char[7];

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                ans[0] = arr[i][j];
                dfs(i,j, 1);
            }
        }
    }

    public static void dfs(int y, int x, int count){
        if(count == 7){
            set.add(String.valueOf(ans));
            return;
        }

        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(0 > ny || ny >= 4 || 0 > nx || nx >= 4) continue;
            
            ans[count] = arr[ny][nx];
            dfs(ny, nx, count+1);
        }
        
    }
}
