import java.io.*;
import java.util.*;

public class B16637 {//16637 ?ÑÏ†Ñ?êÏÉâ
    static int N;
    static int max = Integer.MIN_VALUE;
    static List<Character> operator = new ArrayList<>();
    static List<Integer> number = new ArrayList<>();
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String sen = br.readLine();
        for(int i=0; i<N; i++){
            char temp = sen.charAt(i);
            if(temp == '+' || temp == '-' || temp =='*'){
                operator.add(temp);
            }
            else{
                number.add(temp-'0');
            }
        }

        dfs(number.get(0) , 0);
        System.out.println(max);
    }
    static void dfs(int total, int operIndex){
        
        if(operIndex >= operator.size()){
            max = Math.max(max, total);
            return;
        }
        int noParent = calculate(operator.get(operIndex), total, number.get(operIndex+1));
        dfs(noParent, operIndex+1);

        if(operIndex+1 < operator.size()){
            int parent = calculate(operator.get(operIndex + 1), number.get(operIndex + 1), number.get(operIndex + 2));
            int newTotal = calculate(operator.get(operIndex), total, parent);
            dfs(newTotal, operIndex+2);
        }        
    }
    static int calculate(char form, int x, int y){
        switch(form){
            case '+':
                return x+y;
            case '-':
                return x-y;
            case '*':
                return x*y;
            default:
                return -1;
        }
    }
}

