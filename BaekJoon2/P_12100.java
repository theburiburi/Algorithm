import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P_12100 {
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static int N;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][N];

        for(int i=0;i<N; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(arr, 0);
        System.out.println(answer);
    }

    public static void dfs(int arr[][], int count){
        if(count >= 5) {
            for(int i=0;i<N; i++){
                for(int j=0; j<N; j++){
                    answer = Math.max(answer,arr[i][j]);
                }
            }
            return;
        }

        for(int i=0; i<4; i++){
            dfs(move(arr, i), count+1);
        }
    }
    public static void goStraight(int i, int j, int arr[][], boolean visited[][], int direction){

        if(arr[i][j] == 0) return;
        int y = i;
        int x = j;

        while(true){
            int ddy = y+dy[direction];
            int ddx = x+dx[direction];
            if(ddy < 0 || ddy >= N || ddx < 0 || ddx >=N) break;
            else if(arr[ddy][ddx] == 0){
                arr[ddy][ddx] = arr[y][x];
                arr[y][x] = 0;
            }
            else if(arr[ddy][ddx] == arr[y][x] && !visited[ddy][ddx]){
                arr[ddy][ddx] *= 2;
                arr[y][x]=0;
                visited[ddy][ddx] = true;
                break;
            }
            else if(arr[ddy][ddx] != arr[y][x] || visited[ddy][ddx]){
                break;
            }

            y = ddy;
            x = ddx;
        }
    }

    public static int[][] move(int temp[][], int direction){
        boolean visited[][] = new boolean[N][N];
        int arr[][] = new int[N][N];
        for(int i=0; i<N; i++){
            arr[i] = temp[i].clone();
        }
        if(direction == 0){ // 상
            for(int i=1; i<N; i++){
                for(int j=0; j<N; j++){
                    goStraight(i, j, arr, visited, direction);
                }
            }
        }
        else if(direction == 1){ //하
            for(int i=N-2; i>=0; i--){
                for(int j=0; j<N; j++){
                    goStraight(i, j, arr, visited, direction);
                }
            }
        }
        else if(direction == 2){ //좌
            for(int j=1; j<N; j++){
                for(int i=0; i<N; i++){
                    goStraight(i, j, arr, visited, direction);
                }
            }
        }
        else{ // 우
            for(int j=N-2; j>=0; j--){
                for(int i=0; i<N; i++){
                    goStraight(i, j, arr, visited, direction);
                }
            }
        }
        return arr;
    }
}
