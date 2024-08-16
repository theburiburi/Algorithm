import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{ //3687 DP
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] maxDP = new long[101];
        long[] minDP = new long[101];
        int T = Integer.parseInt(br.readLine());

        Arrays.fill(minDP, Long.MAX_VALUE);
        minDP[2] = 1;
        minDP[3] = 7;
        minDP[4] = 4;
        minDP[5] = 2;
        minDP[6] = 6;
        minDP[7] = 8;
        minDP[8] = 10;

        String[] add = {"1", "7", "4", "2", "0", "8"};
        for(int i=9; i<101; i++){
            for (int j=2; j<8; j++){
                String temp = "" + minDP[i-j] + add[j-2];
                minDP[i] = Math.min(minDP[i], Long.parseLong(temp));
            }
        }

        for(int i=0; i<T; i++){
            int count = Integer.parseInt(br.readLine());

            String temp = "";
            if (count % 2 == 1) temp += "7";
            else temp += "1";

            for(int j=1; j < count/2; j++){
                temp += "1";
            }
            sb.append(minDP[count]).append(" ");
            sb.append(temp).append("\n");
        }
        System.out.println(sb.toString());
    }
}