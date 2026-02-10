import java.io.*;
import java.util.*;

public class Solution{
    static int[] input = {1,2,3,4};
    static int N = input.length;
    static int R = 2;
    public static void main(String args[])throws IOException{
        readInput();
        combination(N, R);
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
    }

    public static void combination(int cnt, int start){
        if( cnt == R){
            
            return;
        }
    }
}
