import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1464{//1464
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String sentece = br.readLine();
        String ans = sentece.charAt(0) + "";

        for(int i=1; i<sentece.length(); i++){
            if(sentece.charAt(i) > ans.charAt(i-1)){
                ans = sentece.charAt(i) + ans; 
            }
            else{
                ans = ans + sentece.charAt(i);
            }
        }
        sb.append(ans);
        sb.reverse();
        System.out.println(sb.toString());
    }
}
