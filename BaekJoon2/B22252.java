import java.io.*;
import java.util.*;

public class B22252 { //22252 ?´ì‰¬,?°ì„ ?œìœ„??
    static int Q;
    static HashMap<String, PriorityQueue<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Q = Integer.parseInt(br.readLine());
        long answer = 0;

        for (int i = 0; i < Q; i++) {
            String[] sentence = br.readLine().split(" ");
            String key = sentence[1];
            
            if (sentence[0].equals("1")) { 
                map.putIfAbsent(key, new PriorityQueue<>((s1,s2)-> s2-s1));
                PriorityQueue<Integer> values = map.get(key);
                //List<Integer> values = map.getOrDefault(key, new ArrayList<>());

                for (int j = 3; j < sentence.length; j++) {
                    values.add(Integer.parseInt(sentence[j]));
                }
            } else {
                if (map.containsKey(key)) {
                    int count = Integer.parseInt(sentence[2]);
                    PriorityQueue<Integer> values = map.get(key);

                    for (int j = 0; j < count && !values.isEmpty(); j++) {
                        answer += values.poll();
                    }
                }
            }
        }
        System.out.println(answer);
    }
}

