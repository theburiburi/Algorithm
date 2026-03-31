import java.io.*;
import java.util.*;

public class B2136{
    static StringBuilder sb;
    static int N, L;
    static Node ants[];
    static class Node implements Comparable<Node>{ 
        int position;
        int idx;
        public Node(int distance, int idx){
            this.position = distance;
            this.idx = idx;
        }
        @Override
        public int compareTo(Node o){
            return this.position - o.position;
        }
    }
    public static void main(String args[])throws IOException{
        inputFile();
        System.out.println(sb.toString());
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        ants = new Node[N];

        int time = 0;
        boolean isLeft = false;
        int leftCnt = 0;
        for(int i=0; i<N; i++){
            int now = Integer.parseInt(br.readLine());
            ants[i] = new Node(Math.abs(now), i+1);

            if(now < 0){
                leftCnt++;
                if (time < ants[i].position){
                    time = ants[i].position;
                    isLeft = true;
                }
            }
            else{
                if(time < L-ants[i].position){
                    time = L-ants[i].position;
                    isLeft = false;
                }
            }
        }
        Arrays.sort(ants);


        sb.append(isLeft ? ants[leftCnt-1].idx : ants[leftCnt].idx).append(" ").append(time);
    }
}
