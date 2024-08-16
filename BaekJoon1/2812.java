import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

import java.util.ArrayList;
import java.util.Collections;

public class Main{ //2812 그리디
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> crane = new ArrayList<>();
        ArrayList<Integer> box = new ArrayList<>();

        for (int i=0; i < N; i++){
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int j=0; j < M; j++){
            box.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        int count = 0;
        if(crane.get(0) < box.get(0)){ 
            System.out.println("-1");
            System.exit(0); // exit(0) -> 정상종료 , exit(-1) -> 비정상종료
        }
        while(!box.isEmpty()){
            int idx = 0;
            for(int i=0; i<N;){
                if (box.size() == idx) break;
                else if(crane.get(i) >= box.get(idx)){
                    box.remove(idx);
                    i++;
                }
                else idx++;
            }
            count++;
        }
        System.out.println(count);
    }
}