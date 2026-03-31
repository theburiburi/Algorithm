import java.io.*;
import java.util.*;

public class B16438{
    static StringBuilder sb;
    static char arr[][];
    static int N;
    public static void main(String args[])throws IOException{
        inputFile();
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new char[8][N];
        
        for(int i=0; i<8; i++){
            Arrays.fill(arr[i], 'A');
        }

        dfs(0, N, 0, 'A');
        sb = new StringBuilder();
        for(int i=1; i<=7; i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int left, int right, int day, char shape){
        if(day >= 8) return;
        
        int mid = (left+right+1)/2;        
        
        for(int i=left; i<right; i++){
            arr[day][i] = shape;
        }

        dfs(left, mid, day+1, shape == 'A' ? 'A' : 'B');
        dfs(mid, right, day+1, shape == 'A' ? 'B' : 'A');
    }
}
