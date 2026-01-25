import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Stack;
public class P_1863{ //1863 그리???�택
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st;
        
        int ans = 0;
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > y){
                stack.pop();
                ans++;
            }

            if (!stack.isEmpty() && stack.peek() == y){
                continue;
            }

            if(y != 0) stack.push(y);
        }

        while(!stack.isEmpty()){
            stack.pop();
            ans++;
        }

        System.out.println(ans);
    }
}
