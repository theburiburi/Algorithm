import java.io.*;
import java.util.*;

public class Main {//23349
    static class Node implements Comparable<Node>{
        String place;
        int startTime;
        public Node(String place, int startTime){
            this.place = place;
            this.startTime = startTime;
        }

        @Override
        public int compareTo(Node o) {
            if (!place.equals(o.place)) {
                return place.compareTo(o.place);
            }
            return startTime - o.startTime;
        }
    }

    static HashMap<String, TreeMap<Integer, Integer>> map = new HashMap<>();
    static HashSet<String> name = new HashSet<>();
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String sentence[] = br.readLine().split(" ");
            if(!name.contains(sentence[0])){
                name.add(sentence[0]);

                int start = Integer.parseInt(sentence[2]);
                int end = Integer.parseInt(sentence[3]);
                
                TreeMap<Integer, Integer> TM = map.computeIfAbsent(sentence[1], k -> new TreeMap<>()); //참조
                for(int j = start; j<end; j++){
                    TM.put(j, TM.getOrDefault(j, 0) + 1);
                    max = Math.max(max, TM.get(j));
                }
            }
        }
        List<Node> list = new ArrayList<>();
        for(String place : map.keySet()){
            TreeMap<Integer, Integer> TM = map.get(place);
            for(Map.Entry<Integer, Integer> mapEntry : TM.entrySet()){
                int time = mapEntry.getKey();
                if(mapEntry.getValue() == max){
                    list.add(new Node(place, mapEntry.getKey()));
                    break;
                }
            }
        }

        list.sort(null);
        Node node = list.get(0);
        int endTime = findEnd(map.get(node.place), node.startTime);
        System.out.println(node.place+" "+node.startTime+" "+endTime);
    }
    static int findEnd(TreeMap<Integer, Integer> TM, int start){
        int end = start;
        while(TM.containsKey(end) && TM.get(end) == max){
            end++;
        }
        return end;
    }
}
