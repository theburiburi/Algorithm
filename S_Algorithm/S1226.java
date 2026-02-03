import java.io.*;
import java.util.*;

public class S1226 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        for(int i=1; i<=10; i++){
            br.readLine();
            int arr[][] = new int[16][16];
            int startPoint[] = new int[2];
            int endPoint[] = new int[2];
            
            sb.append("#"+i+" ");
            for(int j=0; j<16; j++){
                String input[] = br.readLine().split("");
                for(int k=0; k<16; k++){
                    arr[j][k] = Integer.parseInt(input[k]);
                    if(arr[j][k] == 2){
                        startPoint[0] = j;
                        startPoint[1] = k;
                    }
                    else if(arr[j][k] == 3){
                        endPoint[0] = j;
                        endPoint[1] = k;
                    }
                }
            }

            sb.append(bfs(arr, startPoint[0],startPoint[1], endPoint[0], endPoint[1])+"\n");            
        }
        System.out.println(sb);
    }

    public static int bfs(int arr[][], int startY, int startX, int endY, int endX){
        Queue<int[]> que = new LinkedList<>();
        boolean visited[][] = new boolean[16][16];
        que.add(new int[]{startY,startX});

        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        while(!que.isEmpty()){
            int now[] = que.poll();
            int y = now[0];
            int x = now[1];
            visited[y][x] = true;
            if(y == endY && x == endX) return 1;
            for(int i=0; i<4; i++){
                int ddy = y + dy[i];
                int ddx = x + dx[i];

                if(0<= ddy && ddy<16 && 0<=ddx && ddx<16){
                    if(!visited[ddy][ddx] && arr[ddy][ddx] != 1){
                        que.add(new int[]{ddy,ddx});
                    }
                }
            }
        }
        return 0;
    }
}
