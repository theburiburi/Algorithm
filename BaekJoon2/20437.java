import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{ //20437 문자열
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++){
            int alpha[] = new int[26]; 
            String str = br.readLine();
            int K = Integer.parseInt(br.readLine());
            int minLength = Integer.MAX_VALUE;
            int maxLength = -1;

            if(K == 1){
                sb.append("1 1").append("\n");
                continue;
            }

            for(int j=0; j<str.length(); j++){
                alpha[str.charAt(j) - 'a']++;
            }

            for(int j=0; j<str.length(); j++){
                if(alpha[str.charAt(j) - 'a'] < K) continue;

                int count = 1;
                for(int k=j+1; k<str.length(); k++){
                    if (str.charAt(j) == str.charAt(k)){
                        count++;
                    }
                    if(count == K){
                        minLength = Math.min(minLength, k-j+1);
                        maxLength = Math.max(maxLength, k-j+1);
                        break;
                    }
                }
            }
            if(minLength == Integer.MAX_VALUE){
              sb.append("-1").append("\n");
            } 
            else{
            sb.append(minLength + " " + maxLength).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}