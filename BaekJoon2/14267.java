import java.io.*;
import java.util.*;

public class 14267 { //14267 트리
    static List<Integer> list[];
    static int praises[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        praises = new int[n+1];

        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            int firm = Integer.parseInt(st.nextToken());
            if (firm != -1){
                list[firm].add(i);
            }
        }
        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int employee = Integer.parseInt(st.nextToken());
            int praise = Integer.parseInt(st.nextToken());
            praises[employee] += praise;
        }
        dfs(1);

        for(int i=1; i<=n; i++){
            sb.append(praises[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
    static void dfs(int now){
        for(int next : list[now]){
            praises[next] += praises[now];
            dfs(next);
        }
    }
}
