import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1701{//String , KMP
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sentence = br.readLine();
        int maxLen = 0;

        int senLen = sentence.length();
        for(int i=0; i<senLen; i++){
            String subString = sentence.substring(i, senLen);
            maxLen = Math.max(maxLen, kmp(subString));
        }
        System.out.println(maxLen);
    }
    static int kmp(String subString){
        int max = 0;
        int LI = 0;
        int subLen = subString.length();
        int pi[] = new int[subLen];

        for(int RI=1; RI<subLen; RI++){
            while(LI>0 && subString.charAt(LI) != subString.charAt(RI)){
                LI = pi[LI-1];
            }
            if(subString.charAt(LI) == subString.charAt(RI)){
                pi[RI] = ++LI;
                max = Integer.max(max, pi[RI]);
            }
        }

        return max;
    }
}
