import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_7490{//문자??브루?�포??
    static int T;
    static String N;
    static final String letter[] = {" ", "+", "-"};

    static StringBuilder sb;

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        
        for (int i=0; i<T; i++){
            N = br.readLine();
            dfs("1", 2);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(String now, int index){
        if(index == Integer.parseInt(N)+1){
            calculate(now);
            return;
        }
        for(int i=0; i<3; i++){
            dfs(now + letter[i] + index, index+1);
        }
    }
    static void calculate(String sentence){
        int currentNum = 0;
        int sum = 0;
        char operator = '+';

        String temp = sentence.replace(" ", "");
        for(int i=0; i<temp.length(); i++){
            char ch = temp.charAt(i);
            if(Character.isDigit(ch)){
                currentNum = currentNum*10 + (ch-'0');
            }
            else{
                if(operator == '+'){
                    sum += currentNum;
                }
                else if(operator == '-'){
                    sum -= currentNum;
                }
                operator = ch;
                currentNum = 0;
            }
        }
        if (operator == '+') {
            sum += currentNum;
        } else if (operator == '-') {
            sum -= currentNum;
        }
        if(sum == 0){
            sb.append(sentence).append("\n");
        }
    }
}
