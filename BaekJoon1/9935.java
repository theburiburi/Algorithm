import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{ //9935 문자열
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> st = new Stack<>();

        String word = br.readLine();
        String bomb = br.readLine();


        for(int i=0; i< word.length(); i++){
            st.push(word.charAt(i));
            if(st.size() >= bomb.length()){
                boolean flag = true;

                for(int j=0; j<bomb.length(); j++){
                    if(st.get(st.size()-1-j) != bomb.charAt(bomb.length()-1-j)){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    for(int j=0; j<bomb.length(); j++){
                        st.pop();
                    }
                }
            }
        }
        for(Character c : st){ // *** stack이어도 앞에서부터 나온다. ***
            sb.append(c);
        }
        System.out.println(sb.length()==0 ? "FRULA" : sb.toString());

    }
}