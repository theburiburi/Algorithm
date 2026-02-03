import java.io.*;
import java.util.*;

public class B2457 { //2457 그리??
    static int N;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            int temp[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if(temp[2]>=3){ // 종료가 3?�보????곳만 ?�기
                list.add(new int[]{temp[0]*100 + temp[1], temp[2]*100 + temp[3]});
            }
        }
        list.sort((s1,s2)-> {
            if(s1[0] == s2[0]) return s2[1] - s1[1];
            return s1[0] - s2[0];
        });


        int threshold = 301; //3M1D
        int ans = 0;
        int index = 0;
        while(threshold < 1201){ //1130?�면 꽃이 진다.
            boolean found = false;
            int maxDay = threshold;
            for(; index<list.size(); index++){
                int temp[] = list.get(index);

                if (temp[0] > threshold) break;
                if (temp[1] > maxDay){
                    maxDay = temp[1];
                    found = true;
                }
            }
            if(!found){
                ans = 0;
                break;
            }
            threshold = maxDay;
            ans++;
        }
        System.out.println(ans);

    }
}

