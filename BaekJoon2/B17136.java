import java.io.*;
import java.util.*;

public class B17136 { //17136
    static int paper[] = {5,5,5,5,5};
    static int ans = Integer.MAX_VALUE;
    static int arr[][] = new int[10][10];;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<10; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(0,0,0);
        if(ans == Integer.MAX_VALUE){
            ans = -1;
        }
        System.out.println(ans);
    }
    
    public static void dfs(int y, int x, int count){
        if(y >= 9 && x > 9){
            ans = Math.min(ans, count);
            return;
        }
        if(x>9){ 
            dfs(y+1, 0, count); 
            return;
        }
        if(count >= ans){ return; }

        if(arr[y][x] == 1){
            for (int i=0; i<5; i++){
                if(paper[i]>0 && isAttach(y, x, i)){
                    change(y,x,i,0);
                    paper[i]--;
                    dfs(y, x+1, count+1);
                    change(y,x,i,1);
                    paper[i]++;
                }
            }
        }
        else{
            dfs(y, x+1, count);
        }
    }
    public static void change(int y, int x, int size, int state){
        for(int i=y; i<y+size+1; i++){
            for(int j=x; j<x+size+1; j++){
                arr[i][j] = state;
            }
        }
    }

    public static boolean isAttach(int y, int x, int size){
        for(int i=y; i<y+size+1; i++){
            for(int j=x; j<x+size+1; j++){
                if(j > 9 || i > 9 || arr[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
