import java.io.*;
import java.util.*;

public class B1725{
    static int N;
    static int height[];
    public static void main(String args[])throws IOException{
        inputFile();
        solution();
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        height = new int[N+2];

        for(int i=1; i<=N; i++){
            height[i] = Integer.parseInt(br.readLine());
        }
    }

    static void solution(){
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxWidth = 0;

        for(int i=1; i<=N+1; i++){
            while(!stack.isEmpty() && height[stack.peek()] > height[i]){
                int high = height[stack.pop()];
                int width = i - stack.peek() - 1;
                maxWidth = Math.max(maxWidth, high*width);
            }
            stack.push(i);
        }

        System.out.println(maxWidth);
    }
}
