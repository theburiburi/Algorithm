import java.io.*;
import java.util.*;

public class S7206{
    static StringBuilder sb;
    static Map<String, Integer> memo;
    public static void main(String args[])throws IOException{
        readInput();
        System.out.println(sb);
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        memo = new HashMap<>();
        for(int t=1; t<=T; t++){
            String num = br.readLine();
            sb.append("#"+t+ " "+ solve(num) +"\n");
        }
    }
    public static int solve(String num){
        if(num.length() == 1) return 0;
        if(memo.containsKey(num)) return memo.get(num);

        int ans = 0;
        for(int i=1; i < (1 << num.length()-1); i++){// 비트 만들기
            int start = 0;
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<num.length()-1; j++){ // 자르기
                if((i & (1<<j)) != 0){
                    String num1 = num.substring(start, j+1);
                    list.add(Integer.parseInt(num1));
                    start = j+1;
                }
            }
            list.add(Integer.parseInt(num.substring(start)));
            int multiNum = 1;
            for(int n : list){
                multiNum *= n;
            }

            ans = Math.max(ans, solve(multiNum+"")+1);
        }
        memo.put(num, ans);

        return ans;
    }
}
