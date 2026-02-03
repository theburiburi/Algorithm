import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
//import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {//implements Comparable<Node>{
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    // @Override
    // public int compareTo(Node other){
    //     return Integer.compare(x+y, other.x+other.y);
    // }
}

public class B9205{ //그래??BFS
    static int N;
    static int M;
    static Node sPoint, ePoint;
    static Boolean visited[];
    static Node convenience[];
    static Queue<Node> que;
    static StringBuilder sb;
    public static void main(String argsp[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int i=0; i<N; i++){
            M = Integer.parseInt(br.readLine());
            convenience = new Node[M];
            visited = new Boolean[M];
            
            Arrays.fill(visited, false);
            
            for(int j=0; j<M+2; j++){
                st = new StringTokenizer(br.readLine());
                int tempX = Integer.parseInt(st.nextToken());
                int tempY = Integer.parseInt(st.nextToken());
                if (j == 0){
                    sPoint = new Node(tempX, tempY);
                }
                else if(j == M+1){
                    ePoint = new Node(tempX, tempY);
                }
                else{
                    convenience[j-1] = new Node(tempX, tempY);
                }
            }
            
            search();
        }
        System.out.print(sb.toString());
    }

    static boolean manhattan(Node point1, Node point2){
        return Math.abs(point1.x - point2.x) + Math.abs(point1.y-point2.y) <= 1000 ? true : false; 
    }

    static void search(){
        
        que = new LinkedList<>();
        que.offer(sPoint);

        if (manhattan(sPoint, ePoint)){
            sb.append("happy"+"\n");
            return;
        }
        while(!que.isEmpty()){
            Node next = que.poll();
            if (manhattan(next, ePoint)){
                sb.append("happy"+"\n");
                return;
            } 
            for (int i=0; i<M; i++){
                if(manhattan(next, convenience[i])&&(!visited[i])){
                    que.offer(convenience[i]);
                    visited[i] = true;
                }
            }
        }
        sb.append("sad"+"\n");
    } 
}
