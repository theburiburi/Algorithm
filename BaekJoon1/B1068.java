import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1068{//그래?? ?�리
    static ArrayList<Integer> graph[];
    static boolean[] visited;
    static int root;
    static int delete;
    static int ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[N];
        visited = new boolean[N];

        for (int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }

        String arr[] = br.readLine().split(" ");
        delete = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            int temp = Integer.parseInt(arr[i]);
            if(temp == -1){
                root = i;
            }
            else{
                graph[i].add(temp);
                graph[temp].add(i);
            }
        }

        if(delete == root){
            System.out.println(0);
        }
        else{
            dfs(root);
            System.out.println(ans);
        }
        
    }

    static void dfs(int current){
        visited[current] = true;
        int node=0;
        for(int temp : graph[current]){
            if(!visited[temp] && delete != temp){
                node++;
                dfs(temp);
            }
        }
        if (node == 0) ans++;
    }
}
