import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class Main{ //17144 구현
    static int[] cleaner;
    static int[][] place;
    static int R, C, T;
    static Queue <Dusts> dusts;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int temp = 0;
        int ans = 2;
        place = new int[R][C];
        cleaner = new int[2];
        for (int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<C; j++){
                place[i][j] = Integer.parseInt(st.nextToken());
                if (place[i][j] == -1){
                    cleaner[temp++] = i;
                }
            }
        }
        for(int i=0; i<T; i++){
            check();
            spread();
            clean();
        }

        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                ans += place[i][j];
            }
        }
        System.out.print(ans);
    }

    public static class Dusts{
        int x,y,z;
        public Dusts(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void check(){
        dusts = new LinkedList<>();
        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                if(place[i][j] == -1 || place[i][j] ==0) continue;
                dusts.add(new Dusts(i,j,place[i][j]));
            }                
        }
    }
    
    public static void spread(){
        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,1,-1};

        while(!dusts.isEmpty()){
            Dusts now = dusts.poll();

            if (now.z < 5) continue;
            int amout = now.z / 5;
            for(int i=0; i<4; i++){
                int xx = now.x + dx[i];
                int yy = now.y + dy[i];

                if(xx < 0 || xx >= R || yy < 0 || yy >= C || place[xx][yy] == -1) continue;
                place[xx][yy] += amout;
                place[now.x][now.y] -= amout;
            }
        }
    }

    public static void clean(){
        //upper
        int row = cleaner[0];
        for (int i = row-1; i > 0; i--){ //down
            place[i][0] = place[i-1][0];
        }
        for (int i = 0; i < C-1; i++){ //left
            place[0][i] = place[0][i+1];
        }
        for (int i = 0; i < row; i++){ //up
            place[i][C-1] = place[i+1][C-1];
        }
        for (int i=C-1; i > 1; i--){ //right
            place[row][i] = place[row][i-1];
        }
        place[row][1] = 0;
        //downer
        row = cleaner[1];
        for (int i = row+1; i < R-1; i++){ //up
            place[i][0] = place[i+1][0];
        }
        for (int i = 0; i < C-1; i++){ //left
            place[R-1][i] = place[R-1][i+1];
        }
        for (int i = R-1; i > row; i--){ //down
            place[i][C-1] = place[i-1][C-1];
        }
        for (int i=C-1; i > 1; i--){ //right
            place[row][i] = place[row][i-1];
        }
        place[row][1] = 0;
    }
}