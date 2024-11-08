import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String sen = br.readLine();
            if(sen.equals("0")){
                break;
            }
            StringBuilder temp = new StringBuilder(sen);
            temp.reverse();
            String sen2 = temp.toString();
            if(sen.equals(sen2)){
                sb.append("yes").append("\n");
            }
            else{
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}