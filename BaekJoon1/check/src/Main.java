import java.io.*;
import java.util.*;

public class Main { //23059 해쉬셋
    static Map<String, ArrayList<String>> connection = new HashMap<>();
    static Map<String, Integer> inDegree = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String prev = st.nextToken();
            String next = st.nextToken();

            if(connection.get(prev) == null){
                connection.put(prev, new ArrayList<>());
                inDegree.put(prev, 0);
            }
            if(inDegree.get(next) == null){
                connection.put(next, new ArrayList<>());
                inDegree.put(next, 0);
            }

            connection.get(prev).add(next);
            inDegree.put(next, inDegree.get(next)+1);
        }

        solution();
        boolean flag = true;
        for(String key : inDegree.keySet()){
            if(inDegree.get(key) != 0){
                flag = false;
                break;
            }
        }
        System.out.println(flag == true ? sb.toString() : "-1");
    }
    static private void solution(){
        ArrayList<String> zeroInDegree = new ArrayList<>();
        Queue<String> que = new LinkedList<>();

        for(String key : inDegree.keySet()){
            if(inDegree.get(key) == 0){
                zeroInDegree.add(key);
            }
        }
        zeroInDegree.sort((s1,s2)-> s1.compareTo(s2));

        for(String key : zeroInDegree){
            que.add(key);
        }

        while(!que.isEmpty()){
            int size = que.size();
            zeroInDegree = new ArrayList<>();

            for(int i=0; i<size; i++){
                String now = que.poll();
                sb.append(now+"\n");

                for(String next : connection.get(now)){
                    inDegree.put(next, inDegree.get(next) - 1);
                    if(inDegree.get(next) == 0){
                        zeroInDegree.add(next);
                    }
                }
            }
            zeroInDegree.sort((s1,s2)->s1.compareTo(s2));
            for(String key : zeroInDegree){
                que.add(key);
            }
        }
    }
}