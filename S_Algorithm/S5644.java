import java.io.*;
import java.util.*;

public class S5644{
    static StringBuilder sb;
    static int dx[] = {0, 0, 1, 0, -1};
    static int dy[] = {0, -1, 0, 1, 0};
    static int M, BCCnt;
    static int[][] map;
    static int maxNum;
    static int power[];

    static int ans;
    public static void main(String args[])throws IOException{
        readInput();
        System.out.println(sb);
    }

    static class Node{
        int y;
        int x;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            BCCnt = Integer.parseInt(st.nextToken());
            ans = 0;
            
            int move1[] = new int[M+1];
            int move2[] = new int[M+1];
            map = new int[10][10];

            Node people1 = new Node(0, 0);
            Node people2 = new Node(9,9);

            power = new int[BCCnt];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int i=1;i<=M; i++){
                move1[i] = Integer.parseInt(st1.nextToken());
                move2[i] = Integer.parseInt(st2.nextToken());
            }

            for(int i=0; i<BCCnt; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                power[i] = p;
                for(int j=y-c; j<=y+c; j++){
                    for(int k=x-c; k<=x+c; k++){
                        if(0<= j && j<10 && 0<=k && k<10){
                            int dx = Math.abs(j-y);
                            int dy = Math.abs(k-x);
                            if(dx+dy <= c){
                                map[j][k] |= 1<<i;
                            }
                        }
                    }
                }
            }
            for(int i=0; i<=M; i++){
                people1.y += dy[move1[i]];
                people1.x += dx[move1[i]];

                people2.y += dy[move2[i]];
                people2.x += dx[move2[i]];

                maxNum = 0;
                dfs(0, map[people1.y][people1.x], map[people2.y][people2.x], 0);
                ans += maxNum;
            }
            sb.append("#"+t+" "+ans+"\n");
        }
    }
    public static void dfs(int idx, int maskA, int maskB, int total) {
        if (idx == BCCnt) {
            maxNum = Math.max(maxNum, total);
            return;
        }

        int currentBC = (1 << idx);

        if ((maskA & currentBC) != 0 && (maskB & currentBC) != 0) {
            dfs(idx + 1, 0, maskB, total + power[idx]);
            dfs(idx + 1, maskA, 0, total + power[idx]);
            dfs(idx + 1, 0, 0, total + power[idx]);
        } 
        else if ((maskA & currentBC) != 0) {
            dfs(idx + 1, 0, maskB, total + power[idx]);
        } 
        else if ((maskB & currentBC) != 0) {
            dfs(idx + 1, maskA, 0, total + power[idx]);
        }

        dfs(idx + 1, maskA, maskB, total);
    }
}
