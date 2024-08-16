import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{//17471 그래프
    static ArrayList<Integer> graph[];
    static boolean include[];
    static boolean visited[];
    static int human[];

    static int N;
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;
        
        include = new boolean[N];
        graph = new ArrayList[N];
        human = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
            human[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int connect = Integer.parseInt(st.nextToken());
            for(int j=0; j<connect; j++){
                graph[i].add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        dfs(0);

        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }
    static void dfs(int index){
        if(index == N){
            ArrayList<Integer> TSide = new ArrayList<>();
            ArrayList<Integer> FSide = new ArrayList<>();
            for (int i=0; i<N; i++){
                if(include[i]){
                    TSide.add(i);
                }
                else FSide.add(i);
            }

            if(TSide.size() == 0 || FSide.size() ==0){
                return;
            }

            if(connectCheck(TSide) && connectCheck(FSide)){
                getPeople();
            }
            return;
        }
        include[index] = false; //이게 없으면 왜 안 되지? 디폴트가 false인데
        dfs(index+1);
        include[index] = true;
        dfs(index+1);
    }
    static boolean connectCheck(ArrayList<Integer> side){
        Queue<Integer> q = new LinkedList<>();
        q.add(side.get(0));
        visited = new boolean[N];
        visited[side.get(0)] = true;
        int count = 1;
        while(!q.isEmpty()){
            int QTemp = q.poll();
            for(int i=0; i < graph[QTemp].size(); i++){
                int GTemp = graph[QTemp].get(i);
                if (side.contains(GTemp) && !visited[GTemp]){
                    q.add(GTemp);
                    visited[GTemp] = true;
                    count++;
                }
            }
        }
        if (count == side.size()) return true;
        else return false;
    }
    static void getPeople(){
        int TNum = 0;
        int FNum = 0;
        for(int i=0; i<N; i++){
            if(include[i]) TNum += human[i];
            else FNum += human[i];
        }
        int diff = Math.abs(TNum - FNum);
        ans = Math.min(diff, ans);
    } 
}