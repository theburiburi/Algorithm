import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 1259 {//String
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String sen;
        
        while (!(sen = br.readLine()).equals("0")) {
            sb.append(sen.equals(new StringBuilder(sen).reverse().toString()) ? "yes\n" : "no\n");
        }
        
        System.out.print(sb);
    }
}