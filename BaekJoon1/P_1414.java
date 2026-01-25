import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P_1414{ //1414 ?¤íŠ¸ë§? ?¬ë£¨?¤ì¹¼
    static int N = 3;
    static PriorityQueue<int[]> pq;
    static int parent[];
    static int count = 1;
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int topology[][] = new int[N+1][N+1];
        parent = new int[N+1];
        int total = 0;

        pq = new PriorityQueue<>((o1, o2)-> o1[2] - o2[2]);
        for(int i=1; i<=N; i++){
            String line = br.readLine();
            for(int j=1; j<=N; j++){
                topology[i][j] = charToNum(line.charAt(j-1));

                if(topology[i][j]==0) continue;
                total += topology[i][j];
                if(i==j) continue;
                pq.add(new int[]{i,j,topology[i][j]});
            }
            parent[i] = i;
        }
        int answer = total - kruskal();

        if(count == N) System.out.println(answer);
        else System.out.println(-1);

    }
    public static int charToNum(char character){
        if ('a' <= character && character <= 'z'){
            return character - 'a' + 1;
        }
        else if ('A' <= character && character <= 'Z') {
            return character - 'A' + 27;
        }
        else{
            return 0;
        }
    }
    public static int kruskal(){
        int cost = 0;
        while(!pq.isEmpty()){
            int [] temp = pq.poll();
            int x_parent = find(temp[0]);
            int y_parent = find(temp[1]);
            if(x_parent != y_parent){
                union(x_parent, y_parent);
                cost += temp[2];
                count++;
            }
        }
        return cost;
    }

    public static int find(int x){
        if(x == parent[x]){
            return x;
        }
        else{
            return parent[x] = find(parent[x]);
        }
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x<y){
            parent[y] = x; 
        }
        else{
            parent[x] = y;
        }
    }
}
