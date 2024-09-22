import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 11657{ //11657 벨만포드 그래프
    static class Node{
        int end;
        int cost;
        public Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
    }
    static int N, M;
    static ArrayList<Node> graph[];
    static long dist[];
    static final int INF = 10000000;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        dist = new long[N+1];

        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
        }

        if(bellman()){
            for(int i=2; i<=N; i++){
                if(dist[i] == INF){
                    System.out.println(-1);
                }
                else{
                    System.out.println(dist[i]);
                }
            }
        }
        else{
            System.out.println(-1);
        }
    }
    static boolean bellman(){
        dist[1] = 0; //처음 위치
        boolean update = false;

        for (int i=1; i<N; i++){ // N-1번 갱신하기
            update = false;
            for(int j=1; j<=N; j++){
                for(Node temp : graph[j]){
                    if (dist[j] == INF) break; //갱신 안 된 곳은 탈출

                    if(dist[temp.end] > dist[j] + temp.cost){
                        dist[temp.end] = dist[j] + temp.cost;
                        update = true;
                    }
                }
            }
            if(!update){ //갱신 안 되면 탈출
                break;
            }
        }

        for(int j=1; j<=N; j++){ // N번째에 갱신될 때 -> 무한
            for(Node temp : graph[j]){
                if(dist[j] == INF) break;
                if(dist[temp.end] > dist[j] + temp.cost){
                    return false;
                }
            }
        }
        return true;
    }
}