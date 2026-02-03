import java.io.*;
import java.util.*;

public class B4195{ //4195 ?´ì‹œë§?
    static int parent[];
    static int height[];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<T; i++){
            int F = Integer.parseInt(br.readLine());
            int count = 0;
            parent = new int[F*2];
            height = new int[F*2];
            for(int j=0; j<2*F; j++){
                parent[j] = j;
                height[j] = 1;
            }
            for(int j=0; j<F; j++){
                String arr[] = br.readLine().split(" ");
                if(!map.containsKey(arr[0])){
                    map.put(arr[0], count++);
                }
                if(!map.containsKey(arr[1])){
                    map.put(arr[1], count++);
                }
                sb.append(union(map.get(arr[0]), map.get(arr[1]))).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    static int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    static int union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            parent[y] = x;
            height[x] += height[y];
        }
        return height[x];
    }
}
