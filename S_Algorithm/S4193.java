import java.io.*;
import java.util.*;

public class S4193 { // 구현 완전탐색
    static int start[];
    static int end[];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int arr[][];
    static int check[][];

    static int answer;
    static int N;
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine().trim());
            arr = new int[N][N];
            check = new int[N][N];
            start = new int[2];
            end = new int[2];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    check[i][j] = Integer.MAX_VALUE;
                }
            }
            st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());
            answer = findMap();

            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }

    public static int findMap(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[2] - b[2]);

        pq.add(new int[]{start[0], start[1], 0});
        check[start[0]][start[1]] = 0;

        while(!pq.isEmpty()){
            int now[] = pq.poll();
            int y = now[0];
            int x = now[1];
            int time = now[2];

            if(y == end[0] && x == end[1]) return time;
            if(time > check[y][x]) continue;

            for(int i=0; i<4; i++){
                int ddy = y + dy[i];
                int ddx = x + dx[i];

                if(0<=ddy && ddy<N && 0 <= ddx && ddx <N && arr[ddy][ddx] != 1){
                    int nextTime = time + 1;

                    if (arr[ddy][ddx] == 2){
                        if(time % 3 == 0) nextTime += 2; //3초 기다리기
                        else if(time % 3 == 1) nextTime += 1; //2초 기다리기
                    }

                    if(check[ddy][ddx] > nextTime){
                        check[ddy][ddx] = nextTime;
                        pq.add(new int[]{ddy,ddx, nextTime});
                    }
                }
            }
        }
        return -1;
    }
}

