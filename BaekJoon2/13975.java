import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{ // 그리디 13975
    public static void main(String[] agrs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            PriorityQueue<Long> pq = new PriorityQueue<>(); //크기 생각해서 자료형 짜기

            long ans = 0;
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){ // 새로운 표현
                pq.add(Long.parseLong(st.nextToken()));
            }
            while(pq.size() > 1){
                long temp1 = pq.poll();
                long temp2 = pq.poll();

                temp1 += temp2;
                ans += temp1;
                pq.add(temp1);
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb.toString());
    }
}