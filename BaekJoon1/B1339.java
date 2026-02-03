import java.io.*;
import java.util.*;

public class B1339 {//1339 그리??
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Integer weight[] = new Integer[26];
        Arrays.fill(weight, 0);
        for(int i=0; i<N; i++){
            String sen = br.readLine();
            int len = sen.length();
            
            for(int j=0; j<len; j++){
                weight[sen.charAt(j)-'A'] += (int)Math.pow(10, len-1-j);
            }
        }
        Arrays.sort(weight, Comparator.reverseOrder());
        int num = 9;
        int sum = 0;
        for(int i=0; i<26; i++){
            if(weight[i] == 0) break;
            sum += weight[i]*num;
            num--;
        }
        System.out.println(sum);
    }
}
