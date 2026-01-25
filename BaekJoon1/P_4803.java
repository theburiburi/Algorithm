import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_4803{ //4803 ?¸ë¦¬ dfs
    static int num = 1;
    static int treeNum, N, M;
    static ArrayList<Integer> graph[];
    static boolean visited[];
    static boolean check;

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            if (N==0 && M==0) break;

            graph = new ArrayList[N+1];
            for(int i=0; i<=N; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            countTree();
            
            sb.append("Case ").append(num++).append(": ");
            switch(treeNum){
                case(0):
                    sb.append("No trees.").append("\n");
                    break;
                case(1):
                    sb.append("There is one tree.").append("\n");
                    break;
                default://else
                    sb.append("A forest of ").append(treeNum).append(" trees.").append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
    static void countTree(){
        treeNum = 0;
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                treeNum++;

                check = true;
                dfs(i, 0);
                if (!check){
                    treeNum--;
                }
            }
        }
    }
    static void dfs(int i, int previous){
        if(visited[i] == true){
            return;
        }
        visited[i] = true;
        for(int temp: graph[i]){
            if(!visited[temp]){
                dfs(temp, i);
            }
            else{
                if(previous != temp) check = false; // ?¬ì´?´ì´ ?ê¸°??ê²½ìš°
            }
        }
    }
}
