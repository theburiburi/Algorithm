import java.io.*;
import java.util.*;

public class Main{
    static int n, b;
    static int typeCnt;

    static TreeMap<Integer, Integer> tm[]; // 성능, 가격
    static HashMap<String, Integer> typeMap;
    static HashMap<Integer, String> reverseMap;
    static PriorityQueue<pqNode> myComputer;

    static StringBuilder sb;
    public static void main(String args[])throws IOException{
        readInput();
        Solution();
        System.out.println(sb);
    }

    static class pqNode implements Comparable<pqNode>{
        int quality;
        int price;
        String type;

        public pqNode(int quality, int price, String type){
            this.quality = quality;
            this.price = price;
            this.type = type;
        }

        @Override
        public int compareTo(pqNode o){
            if(quality == o.quality) return o.price - price;
            return o.quality - quality;
        }
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            int prices[] = new int[n];
            int qualities[] = new int[n];
            String types[] = new String[n];

            myComputer = new PriorityQueue<>();

            int tempIdx = 0;

            typeMap = new HashMap<>();
            reverseMap = new HashMap<>();

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                String type = st.nextToken();
                String name = st.nextToken();
                int price = Integer.parseInt(st.nextToken());
                int quality = Integer.parseInt(st.nextToken());

                if(!typeMap.containsKey(type)){
                    reverseMap.put(tempIdx, type);
                    typeMap.put(type, tempIdx++);
                }

                types[i] = type;
                prices[i] = price;
                qualities[i] = quality;
            }
            typeCnt = typeMap.keySet().size();
            tm = new TreeMap[typeCnt];
            for(int i=0; i<typeCnt; i++){
                tm[i] = new TreeMap<>();
            }

            for(int i=0; i<n; i++){
                tempIdx = typeMap.get(types[i]);
                tm[tempIdx].put(qualities[i], prices[i]);
            }
        }
    }

    public static void Solution(){
        int totalPrice = 0;
        for(int i=0; i<typeCnt; i++){
            
            Map.Entry<Integer, Integer> entry = tm[i].pollLastEntry();
            
            int tempKey = entry.getKey(); //성능 
            int tempVal = entry.getValue(); //가격

            tm[i].pollLastEntry();
            myComputer.add(new pqNode(tempKey, tempVal, reverseMap.get(i)));
            totalPrice += tempVal;
        }
        while(totalPrice > b){
            pqNode now = myComputer.poll();
            int tempIdx = typeMap.get(now.type);
            
            Map.Entry<Integer, Integer> entry = tm[tempIdx].pollLastEntry();
            totalPrice -= now.price;
            totalPrice += entry.getValue();
            myComputer.add(new pqNode(entry.getKey(), entry.getValue(), reverseMap.get(tempIdx)));
        }
        int ans = 0;
        while(!myComputer.isEmpty()){
            ans = myComputer.poll().quality;
        }
        sb.append(ans+"\n");
    }
}
