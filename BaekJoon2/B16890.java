import java.io.*;
import java.util.*;

public class B16890 { //16890 string
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char first[] = br.readLine().toCharArray();
        char second[] = br.readLine().toCharArray();
        
        int n = first.length;
        int firstLeft = 0, firstRight = n/2 + n%2 -1;
        int secondLeft = firstRight+1, secondRight = n-1;
        
        char ans[] = new char[n];
        int ansLeft = 0, ansRight = n-1;
        Arrays.sort(first);
        Arrays.sort(second);
        for(int i=0; i<n; i++){
            if(i%2 == 0){ //?¬ê³¼ ì°¨ë?
                if(first[firstLeft] >= second[secondRight]){
                    ans[ansRight--] = first[firstRight--]; 
                }
                else{
                    ans[ansLeft++] = first[firstLeft++];
                }
            }
            else{ //?ë¸Œ ì°¨ë?
                if(first[firstLeft] >= second[secondRight]){
                    ans[ansRight--] = second[secondLeft++];
                }
                else{
                    ans[ansLeft++] = second[secondRight--];
                }
            }
        }
        
        for(int i=0; i<n; i++){
            sb.append(ans[i]);
        }
        System.out.println(sb.toString());
    
    }
}

