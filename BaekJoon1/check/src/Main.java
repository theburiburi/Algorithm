import java.io.*;
import java.util.*;

public class Main { //1933 treeset
    static class Building implements Comparable<Building>{
        int x, h;

        Building(int x, int h) {
            this.x = x;
            this.h = h;
        }

        @Override
        public int compareTo(Building o){
            if(x == o.x){
                return o.h - h;
            }
            return x - o.x;
        }
    }
    
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Building> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            pq.offer(new Building(l, h));
            pq.offer(new Building(r, -h));
        }

        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        int currentX = 0, currentH = 0;
        map.put(0, 1);

        while (!pq.isEmpty()) {
            Building b = pq.poll();

            if (b.h > 0) {
                map.put(b.h, map.getOrDefault(b.h, 0) + 1);
            } 
            else {
                int val = map.get(-b.h);
                if (val == 1) {
                    map.remove(-b.h);
                } 
                else {
                    map.put(-b.h, val - 1); //replace
                }
            }

            // maxX ~ b.x 중 가장 높은 H를 뽑음
            int height = map.firstKey();
            if (currentX != b.x && currentH != height) {
                sb.append(b.x+" ").append(height+" ");
                currentX = b.x;
                currentH = height;
            }
        }

        System.out.print(sb.toString());
    }
}

