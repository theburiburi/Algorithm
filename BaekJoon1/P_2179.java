import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;

public class P_2179{ //2179 문자??
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> word = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++){
            String temp = br.readLine();
            if(!word.contains(temp)) word.add(temp);
        }

        int ans = 0;
        int index1 = 0;
        int index2 = 0; 
        for (int i=0; i<word.size(); i++){
            String a = word.get(i);
            for (int j=i+1; j<word.size(); j++){
                String b = word.get(j);

                int len = a.length() < b.length() ? a.length() : b.length();
                int count = 0;
                for(int k=0; k<len; k++){
                    if(a.charAt(k) == b.charAt(k))
                        count++;
                    else break;
                }
                if (ans < count){
                    ans = count;
                    index1 = i;
                    index2 = j;
                }
            }
        }
        System.out.println(word.get(index1) +"\n" + word.get(index2));
    }
}
