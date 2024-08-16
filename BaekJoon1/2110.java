import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;
//import java.util.Collections;

public class Main{ //이분 탐색
    static Integer[] house;
    public static void main(String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    house = new Integer[N]; //내림차순 할 때
    for(int i=0; i<N; i++){
        house[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(house);
    int low = 1;
    int high = house[N-1] - house[0];
    while(low < high){
        int mid = (low + high) / 2;
        if (install(mid) < C) {
            high = mid;
        }
        else low = mid + 1;
    }

    System.out.println(low);
    }
    public static int install(int distance){
        int count = 1;
        int last = house[0];
        int next;
        for (int i=1; i<house.length; i++){
            next = house[i];
            if (next - last > distance){
                count++;
                last = next;
            }
        } 
        return count;
    }
}