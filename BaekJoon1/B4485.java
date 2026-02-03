import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

import java.util.PriorityQueue;
import java.util.Arrays;

public class B4485{ //bfs 4485
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int count = 0;
        while(true){
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            if (N == 0) break;
            arr = new int[N][N];
            for (int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cost = bfs();
            ++count;
            sb.append("Problem " + count + ": " + cost + "\n");
        }
        System.out.println(sb.toString());
    }

    public static class Node implements Comparable<Node>{
        int x;
        int y;
        int cost;
        public Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        public int compareTo(Node o){
            return cost - o.cost;
        }
    }

    public static boolean valid(int x, int y){
        if(0 <= x && x < N && 0 <= y && y < N) {
            if (visited[y][x] == false){
                return true;
            }
        }
        return false;
    }

    public static int bfs(){
        PriorityQueue<Node> pq = new PriorityQueue();
        int[][] move = new int[N][N];
        for (int i=0; i<N; i++){
            Arrays.fill(move[i], Integer.MAX_VALUE);
        }
        pq.add(new Node(0,0,arr[0][0]));

        while(!pq.isEmpty()){
            Node current = pq.poll();

            if (visited[current.y][current.x] == true) continue;
            visited[current.y][current.x] = true;
            
            if (current.x == N-1 && current.y == N-1) return current.cost;
            for (int i=0; i<4; i++){
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];
                if (valid(nextX, nextY)){
                    if(move[nextY][nextX] > arr[nextY][nextX]){
                        move[nextY][nextX] = current.cost + arr[nextY][nextX];
                        pq.add(new Node(nextX, nextY, move[nextY][nextX]));
                    }
                }
            }
        }
        return -1;
    }
}
