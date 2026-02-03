import java.io.*;
import java.util.*;

public class S1233 {
    static String arr[];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t=1; t<=10; t++){
            int N = Integer.parseInt(br.readLine());
            arr = new String[N+1];
            
            boolean ans = true;
            if(N % 2 == 0) ans = false;
            for(int i=1; i<=N; i++){
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());

                arr[num] = st.nextToken();

                int count = st.countTokens();
                if(count == 0){
                    if(arr[num].equals("*") || arr[num].equals("-") || arr[num].equals("/") || arr[num].equals("+")) ans = false;
                }
                else if(count == 2){
                    if(!(arr[num].equals("+") || arr[num].equals("-") || arr[num].equals("*") || arr[num].equals("/"))) ans = false;
                }
            }
            if(ans == true){
                sb.append("#"+t+" "+1+"\n");
            }
            else{
                sb.append("#"+t+" "+0+"\n");
            }



        //     int ans = 0;
        //     if(N%2 == 0){//짝수개일때 불가능인 거 같은데
        //         sb.append("#"+t+" "+ans);
        //     } 
        //     else{
        //         ans = dfs(1, N);
        //         if(ans == Integer.MAX_VALUE){
        //             sb.append("#"+t+" "+0+"\n");
        //         }
        //         else{
        //             sb.append("#"+t+" "+ans+"\n");
        //         }
        //     }
        // }
        }
        System.out.println(sb);
    }

    // public static int dfs(int now, int end){
    //     if(arr[now].length() == 1 && (arr[now].equals("+") || arr[now].equals("-") || arr[now].equals("*") || arr[now].equals("/") )){
    //         //연산 기호면

    //         int left = 0;
    //         int right = 0;
    //         if(now*2 <= end) left = dfs(now*2, end);
    //         else return Integer.MAX_VALUE;

    //         if(left == Integer.MAX_VALUE){
    //             return Integer.MAX_VALUE;
    //         }

    //         if(now*2+1 <= end) right = dfs(now*2+1, end);
    //         else return Integer.MAX_VALUE;

    //         if(right == Integer.MAX_VALUE){
    //             return Integer.MAX_VALUE;
    //         }

    //         switch (arr[now]) {
    //             case "+":
    //                 return left+right;
    //             case "-":
    //                 return left-right;
    //             case "*":
    //                 return left * right;
    //             case "/":
    //                 return left / right;
    //             default :
    //                 return Integer.MAX_VALUE;
    //         }
    //     }
    //     else{
    //         //숫자인데 자식이 있거나, 기호인데 자식이 없으면
    //         if(now*2 <= end) return Integer.MAX_VALUE;
    //         return Integer.parseInt(arr[now]);
    //     }
    // }

}
