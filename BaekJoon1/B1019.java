import java.io.*;
import java.util.*;

public class B1019 { //1019
    static int cnt[];
    static int start, end, digit;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        cnt = new int[10];
        digit = 1;
        start = 1;
        end = Integer.parseInt(br.readLine());

        while(start <= end) {
            while(start%10 != 0 && start <= end){
                counting(start, digit);
                start++;
            }
            while(end%10 != 9 && start <= end){
                counting(end, digit);
                end --;
            }

            if(start > end) break;

            start /= 10;
            end /= 10;

            for(int i=0; i<10; i++){
                cnt[i] += (end - start + 1) * digit;
            }

            digit *= 10;
        }
        for(int i : cnt){
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString());
    }

    public static void counting(int num, int digit){
        while(num > 0){
            cnt[num % 10] += digit;
            num /= 10;
        }
    }
}

