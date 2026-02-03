import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14500{//14500 브루?�포??구현
    static int answer = 0;
    static int N;
    static int M;
    static boolean visited[][];
    static int arr[][];

    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        arr = new int[N][M];
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[i][j] = true;
                solution(1, arr[i][j], i, j);
                visited[i][j] = false;
            }
        }
        System.out.println(answer);
    }
    static void solution(int depth, int sum, int y, int x){ // ?�머지 모양
        if(depth == 4){
            answer = Math.max(answer, sum);
            return;
        }
        for(int z=0; z<4; z++){
            int i = y+dy[z];
            int j = x+dx[z];
            if (0<= i && i < N && 0<= j && j < M){
                if(visited[i][j] == false){
                    if(depth == 2){
                        visited[i][j] = true;
                        solution(depth+1, sum + arr[i][j], y, x);
                        visited[i][j] = false;
                    }
                    visited[i][j] = true;
                    solution(depth+1, sum + arr[i][j], i, j);
                    visited[i][j] = false;
                }
            }
        }
    }

}
