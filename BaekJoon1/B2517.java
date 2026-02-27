import java.io.*;
import java.util.*;

public class B2517{
    static StringBuilder sb;
    static int N;
    static int tree[];

    static Player[] player, sortedPlayer;
    static class Player{
        int power;
        int order;
        public Player(int power){
            this.power = power;
        }
    }
    public static void main(String args[])throws IOException{
        inputFile();
        solution();
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        player = new Player[N];
        for(int i=0; i<N; i++){
            int now = Integer.parseInt(br.readLine());
            player[i] = new Player(now);
        }

        sortedPlayer = new Player[N];
        sortedPlayer = player.clone();
        Arrays.sort(sortedPlayer, (a, b) -> Integer.compare(a.power, b.power));

        for(int i=0; i<N; i++){
            sortedPlayer[i].order = i+1;
        }
    }

    static void solution(){
        int size = 1;
        while(size < N) size *= 2;
        size *= 2;

        tree = new int[size];

        for(int i=0; i<N; i++){
            Player now = player[i];

            int loser = query(1, 1, N, 1, now.order-1);
            sb.append((i+1) - loser).append("\n");
            update(1,1,N, now.order);
        }
        System.out.println(sb.toString().trim());
    }    
    
    static int query(int node, int start, int end, int left, int right) {
        if(right < start || left  > end) {
            return 0;
        }

        int mid = (start + end) / 2;

        //완전 포함
        if(left <= start && end <= right) {
            return tree[node];
        }

        return query(node*2, start, mid, left, right) + query(node*2+1, mid+1, end, left, right);
    }



    static void update(int node, int start, int end, int idx) {
        if(idx < start || idx > end) return;
        
        tree[node]++;    
        if(start == end) return;

        int mid = (start + end) / 2;

        update(node*2, start, mid, idx);
        update(node*2+1, mid+1, end, idx);
    }

}
