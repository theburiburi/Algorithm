import java.io.*;
import java.util.*;

public class B19591{
    static StringBuilder sb;
    static Deque<Integer> numDq = new ArrayDeque<>();
    static Deque<Character> calDq = new ArrayDeque<>();
    public static void main(String args[])throws IOException{
        inputFile();
        solution();
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();
        String str = br.readLine();
        int num = 0;
        for(int i=0; i<str.length(); i++){
            if("+-*/".indexOf(str.charAt(i)) >= 0){
                numDq.add(num);
                num = 0;
                calDq.add(str.charAt(i));
            }
            else{
                if(num == 0 && str.charAt(i) == '0') continue;
                num *= 10;
                num += str.charAt(i) -'0';
            }
        }
        numDq.add(num);
    }

    public static void solution(){
        
        while(!calDq.isEmpty()){
            if(calDq.size() > 1){
                char leftCal = calDq.pollFirst();
                char rightCal = calDq.pollLast();
                
                int leftFirst = numDq.pollFirst();
                int rightFirst = numDq.pollLast();

                int leftP = priority(leftCal);
                int rightP = priority(rightCal);
                if(leftP > rightP || (leftP == rightP) && cal(leftFirst, numDq.peekFirst(), leftCal) >= cal(rightFirst, numDq.peekLast(), rightCal)){
                    numDq.addFirst(cal(leftFirst, numDq.pollFirst(), leftCal));
                    numDq.addLast(rightFirst);
                    calDq.addLast(rightCal);
                }
                else{
                    numDq.addLast(cal(rightFirst, numDq.peekLast(), rightCal));
                    numDq.addFirst(leftFirst);
                    calDq.addFirst(leftCal);
                }
                
            }
            else if(calDq.size() == 1){
                char leftCal = calDq.pollFirst();
                int leftFirst = numDq.pollFirst();
                int leftSecond = numDq.pollFirst();

                System.out.println(cal(leftFirst, leftSecond, leftCal));
                return;
            }

        }
    }
    static int priority(char c){
        if(c == '*' || c == '/') return 1;
        return 0;
    }
    static int cal(int num1, int num2, char c){
        if(c == '+') return num1 + num2;
        if(c == '-') return num1 - num2;
        if(c == '*') return num1 * num2;
        else return num1 / num2;
    }
}
