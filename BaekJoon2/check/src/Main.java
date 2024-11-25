import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int deadline;
        int ramenNum;
        public Node(int deadline, int ramenNum){
            this.deadline = deadline;
            this.ramenNum = ramenNum;
        }

        @Override
        public int compareTo(Node o){
            if(deadline == o.deadline){
                return o.ramenNum - this.ramenNum;
            }
            else{
                return this.deadline - o.deadline;
            }
        }

    }

    static int N;
    static int deadMax = 0;
    static List<Integer> list[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int dead = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());
            deadMax = Math.max(dead, deadMax);
            list[dead].add(ramen);
        }

        for(int i=1; i<=N; i++){
            list[i].sort((s1, s2) -> s2 - s1);
        }   
        solution();
    }
    static void solution(){
        Queue<Node> que = new LinkedList<>();

        int time = 0;
        int total = 0;

        que.add(new Node(0, 0));
        while(!que.isEmpty()){
            Node now = que.poll();
            if(now.deadline < time){ //없어도 됨?
                continue;
            }

            total += now.ramenNum;
            time++;

            int rememberDead = -1;
            int rememberSize = -1;
            int maxValue = 0;
            boolean visited = false;
            int visitIndex = time;
            for(int i = time; i<=deadMax; i++){ 
                if(list[i].size() == 0 && visited == false){ 
                    visitIndex = i+1; // 4, 5 같은 시작부터 비어있는 곳 빼고 6부터 찾기위해 쓰는 변수
                }
                else if(list[i].size()>(i-visitIndex)){
                    visited = true;
                    if(maxValue < list[i].get(i-visitIndex)){
                        rememberDead = i;
                        maxValue = list[i].get((i-visitIndex));
                        rememberSize = (i-visitIndex);
                    }                    
                }
            }
            if(rememberDead != -1){
                for(int i=0; i<=rememberSize; i++){
                    que.add(new Node(rememberDead, list[rememberDead].get(0)));
                    list[rememberDead].remove(0);
                }
            }

        }
        System.out.println(total);
    }
}