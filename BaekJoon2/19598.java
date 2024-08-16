import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main{ //19598 그리디
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Time> al = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            al.add(new Time(start, end));
        }
        Collections.sort(al);
        
        Time temp = al.get(0);
        pq.add(temp.end);
        for(int i=1; i<N; i++){
            Time temp0 = al.get(i);
            if(pq.peek() <= temp0.start){
                pq.poll();
                pq.add(temp0.end);
            }
            else{
                pq.add(temp0.end);
            }
        }
        System.out.println(pq.size());
    }
    static class Time implements Comparable<Time>{
        int start;
        int end;
        public Time(int start, int end){
            this.start = start;
            this.end = end;            
        }
        public int compareTo(Time O){
            if(start == O.start){
                return end - O.end;
            }
            return start - O.start;
        }
    }
}