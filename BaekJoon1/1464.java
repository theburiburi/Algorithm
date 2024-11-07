import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 1464{//1464
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();
        
        for(int i=0; i<S.length(); i++){
            list.add(S.charAt(i));
        }
        list.sort((s1, s2)-> s1-s2);
        for(char temp : list){
            sb.append(temp);
        }
        sb.append("\n");
        System.out.println(sb.toString());
    }
}