import java.io.*;
import java.util.*;

public class S5648{
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    static StringBuilder sb;
    public static void main(String args[])throws IOException{
        readInput();
        System.out.println(sb);
    }
    public static class Atom{
        int y;
        int x;
        int direction;
        int energy;
        public Atom(int y, int x, int direction, int energy){
            this.y = y;
            this.x = x;
            this.direction = direction;
            this.energy = energy;
        }
    }

    static Atom atom[];
    static int arr[][];
    static int N, ans;
    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            ans = 0;

            atom = new Atom[N];
            arr = new int[4001][4001];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int x = (Integer.parseInt(st.nextToken()) + 1000)*2;
                int y = (Integer.parseInt(st.nextToken()) + 1000)*2;
                int direction = Integer.parseInt(st.nextToken());
                int enerygy = Integer.parseInt(st.nextToken());

                atom[i] = new Atom(y, x, direction, enerygy);
                arr[y][x] = enerygy;
            }
            
            solution();
            sb.append("#"+t+ " "+ ans+"\n");
        }
    }
    public static void solution(){

        boolean check[] = new boolean[N];
        int count = 0;

        for(int i=0; i<4000; i++){
            for(int j=0; j<N; j++){
                if(check[j])continue;
                if(count == N) return;

                arr[atom[j].y][atom[j].x] = 0;
                
                atom[j].y += dy[atom[j].direction];
                atom[j].x += dx[atom[j].direction];
                
                if(atom[j].y < 0 || atom[j].y > 4000 || atom[j].x < 0 || atom[j].x > 4000){
                    check[j] = true;
                    count++;
                    continue;
                }

                arr[atom[j].y][atom[j].x] += atom[j].energy;

                if(arr[atom[j].y][atom[j].x] > atom[j].energy){
                    ans += atom[j].energy;
                    check[j] = true;
                    count++;
                }
            }

            for(int j=0; j<N; j++){
                if(check[j]) continue;
                int y = atom[j].y;
                int x = atom[j].x;
                
                if(arr[y][x] > atom[j].energy){
                    ans += atom[j].energy;
                    check[j] = true;
                    count++;
                    arr[y][x] = 0;
                }
            }

        }
    }
}
