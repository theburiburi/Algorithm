import java.io.*;
import java.util.*;

public class S7793{
    static StringBuilder sb;
    static int N, M, ans;

    static int dx[] = {0,0, -1, 1};
    static int dy[] = {1,-1, 0, 0};
    static char[][] arr;

    static Queue<Integer> devil;
    static Queue<Integer> suyeon;
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
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new char[N][M];
            
            devil = new LinkedList<>();
            suyeon = new LinkedList<>();

            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<M; j++){
                    arr[i][j] = str.charAt(j);
                    if(arr[i][j] == 'S'){
                        suyeon.add(makeKey(i, j));
                    }
                    else if(arr[i][j] == '*'){
                        devil.add(makeKey(i, j));
                    }
                }
            }
            ans = -1;
            solve();
            sb.append("#").append(t).append(" ").append(ans != -1 ? ans : "GAME OVER").append("\n");
        }
    }

    static void solve(){
        int count = 0;
        while(!suyeon.isEmpty()){
            count++;
            int size = suyeon.size();
            for(int i=0; i<size; i++){
                int now[] = decodeKey(suyeon.poll());
                if(arr[now[0]][now[1]] == '*') continue;
                
                for(int j=0; j<4; j++){
                    int ny = now[0] + dy[j];
                    int nx = now[1] + dx[j];

                    if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                    if(arr[ny][nx] == 'D'){
                        ans = count;
                        return;
                    }
                    if(arr[ny][nx] == '.'){
                        arr[ny][nx] = 'S';
                        suyeon.add(makeKey(ny, nx));
                    }
                }
            }


            size = devil.size();
            for(int i=0; i<size; i++){
                int now[] = decodeKey(devil.poll());

                for(int j=0; j<4; j++){
                    int ny = now[0] + dy[j];
                    int nx = now[1] + dx[j];

                    if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                    

                    if(arr[ny][nx] == '.' || arr[ny][nx] == 'S'){
                        arr[ny][nx] = '*';
                        devil.add(makeKey(ny, nx));
                    }
                }
            }
        }
    }

    static int makeKey(int y, int x){
        return y*100 + x;
    }

    static int[] decodeKey(int v){
        return new int[] {v/100, v%100};
    }
}
