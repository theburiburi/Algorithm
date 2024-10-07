import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 16120{ //16120 문자열, 스택
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String sentence = br.readLine();

        int pCount = 0;
        boolean isValid=true;
        for(int i=0; i<sentence.length(); i++){
            char ch = sentence.charAt(i);
            if(ch == 'P'){
                stack.add(ch);
                pCount++;
            }
            else if(ch == 'A' && pCount>=2 && i+1 < sentence.length() && sentence.charAt(i+1) == 'P'){
                stack.pop();
                pCount--;
                i++;
            }
            else{
                isValid = false;
                break;
            }
        }

        if(isValid && stack.size()==1 && stack.peek()=='P'){
            System.out.println("PPAP");
        }
        else{
            System.out.println("NP");
        }
    }
}