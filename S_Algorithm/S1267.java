import java.io.*;
import java.util.*;

public class S1267{
    static int V, E;
    static int[] degree;
    static List<Integer> list[];
    static StringBuilder sb;
    public static void main(String args[])throws IOException{
        readInput();
        System.out.println(sb.toString().trim());
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        for(int t=1; t<=10; t++){
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            degree = new int[V+1];
            list = new ArrayList[V+1];

            for(int i=1; i<=V; i++){
                list[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<E; i++){
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                list[parent].add(child);
                degree[child]++;
            }
            sb.append("#").append(t).append(" ");
            solution();
            sb.append("\n");
        }
    }
    static void solution(){
        Queue<Integer> que = new LinkedList<>();
        for(int i=1; i<=V; i++){
            if(degree[i] == 0){
                que.add(i);
            }
        }
        while(!que.isEmpty()){
            int now = que.poll();
            sb.append(now).append(" ");
            for(int next : list[now]){
                degree[next]--;
                if(degree[next] == 0){
                    que.add(next);
                }
            }
        }
    }
}
