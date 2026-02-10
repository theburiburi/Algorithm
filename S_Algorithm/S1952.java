import java.io.*;
import java.util.*;

public class S1952{
    static StringBuilder sb;
    static int ans;
    static int[] plan, price;
    public static void main(String args[])throws IOException{
        readInput();
        System.out.println(sb);
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            price = new int[4];
            plan = new int[12];
            
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<4;i++){
                price[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<12;i++){
                plan[i] = Integer.parseInt(st.nextToken());
            }
            ans = price[3];
            sb.append("#"+t+ " ");
            dfs(0 , 0);
            sb.append(ans+"\n");
        }
    }
    public static void dfs(int month, int total){
        if(total >= ans) return;
        if(month >= 12){
            ans = Math.min(ans, total);
            return;
        }

        if(plan[month] == 0) {
            dfs(month+1, total);
            return;
        }
        dfs(month+1, total+price[0]*plan[month]);
        dfs(month+1, total+price[1]);
        dfs(month+3, total+price[2]);
        
    }
}
