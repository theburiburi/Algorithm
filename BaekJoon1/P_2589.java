import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class P_2589{//2589ë²?ê·¸ëž˜??bfs
    static int R,C;
    static String arr[][];
    static int time = -1;
    static boolean visited[][];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new String[R][C];
        for(int i=0; i<R; i++){
            arr[i] = br.readLine().split("");
        }
        
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if (arr[i][j].equals("L")){
                    bfs(i, j);
                }
            }
        }
        System.out.println(time);
    }
    static class Node{
        int i,j,count;
        public Node(int i, int j, int count){
            this.i = i;
            this.j = j;
            this.count = count;
        }
    }
    static void bfs(int i, int j){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        visited = new boolean[R][C];

        Queue<Node> que = new LinkedList<>();
        que.add(new Node(i, j, 0));
        visited[i][j] = true;
        while(!que.isEmpty()){
            Node temp = que.poll();
            if (time < temp.count) time = temp.count;
            for(int k=0; k<4; k++){
                int x = temp.j + dx[k];
                int y = temp.i + dy[k];
                if(possible(y, x)){
                    visited[y][x] = true;
                    que.add(new Node(y, x, temp.count+1));
                    // time = Math.max(time, temp.count+1); ê°™ì? ?œí˜„
                }
            }
        }
    }
    static boolean possible(int y, int x){
        if(0<=y && y<R && 0<=x && x<C){
            if(arr[y][x].equals("L")){
                if (!visited[y][x]) return true;
            }
        }
        return false;
    }
}
