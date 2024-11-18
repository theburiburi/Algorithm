import java.io.*;
import java.util.*;

public class Main{ //2412 bfs
    static class Node{
        int x;
        int y;
        int count;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int n, T;
    static List<Integer> list[];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        list = new ArrayList[T+1];
        for(int i=0; i<=T; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[y].add(x);
        }

        for(int i=0; i<=T; i++){
            list[i].sort((x,y)-> x-y);
        }

        System.out.println(bfs());

    }

    public static int bfs(){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0));
        int count = 0;
        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0; i<size; i++){
                Node now = que.poll();
                if(now.y == T) return count;

                for(int y=now.y-2; y<=now.y+2; y++){
                    if(y<0 || y>T) continue;
                    for(int j=0; j<list[y].size(); j++){
                        int x = list[y].get(j);
                        if(now.x+2 < x) break;
                        else if(now.x-2 > x) continue;

                        list[y].remove(j);
                        j--;
                        que.add(new Node(x, y));
                    }
                }
            }
            count++;
        }
        return -1;
    }
}