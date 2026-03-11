import java.io.*;
import java.util.*;

public class S2382{
    static StringBuilder sb;
    static int dx[] = {0, 0, 0, -1, 1};
    static int dy[] = {0, -1, 1, 0, 0};
    static int N, M, K, ans;
    static int arr[][];
    static List<Node> list;
    public static void main(String args[])throws IOException{
        readInput();
        System.out.println(sb.toString());
    }
    static class Node{
        int y;
        int x;
        int count;
        int direction;

        public Node(int y, int x, int count, int direction){
            this.y = y;
            this.x = x;
            this.count = count;
            this.direction = direction;
        }
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            list = new ArrayList<>();
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());

                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken());
                
                arr[y][x] = count;
                list.add(new Node(y, x, count, direction));
            }
            solve();
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
    }

    static void solve(){
        for(int m=0; m<M; m++){
            for(int i=0; i<K; i++){
                Node now = list.get(i);
                if(now.count == 0) continue;

                int y = now.y;
                int x = now.x;

                int ny = y + dy[now.direction];
                int nx = x + dx[now.direction];
                
                now.y = ny;
                now.x = nx;
                arr[y][x] -= now.count;
                if(ny == 0 || nx == 0 || ny == N-1 || nx == N-1){
                    now.count /= 2; // 1 2 3 4
                    now.direction = (now.direction % 2 == 1) ? now.direction + 1: now.direction - 1;
                }
                arr[ny][nx] += now.count;
            }

            
            boolean visited[] = new boolean[K];
            for(int i=0; i<K; i++){
                if(visited[i]) continue;

                Node now = list.get(i);
                if(arr[now.y][now.x] != now.count){
                    int totalCnt = now.count;
                    int maxCnt = now.count;
                    int maxIdx = i;
                    for(int j=i+1; j<K; j++){
                        Node next = list.get(j);
                        if(now.y == next.y && now.x == next.x){
                            totalCnt += next.count;
                            if(maxCnt < next.count){
                                maxCnt = next.count;
                                maxIdx = j;
                            }
                            visited[j] = true;
                            next.count = 0;
                        }
                    }
                    now.count = 0;
                    list.get(maxIdx).count = totalCnt;
                }
                visited[i] = true;
            }
        }
        ans = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                ans += arr[i][j];
            }
        }
    }
}






