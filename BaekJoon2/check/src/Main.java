import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Deque<Integer> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort((s1,s2)->s2 - s1);
        deque = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            if(i%2 == 0){
                deque.addFirst(list.get(i));
            }
            else{
                deque.addLast(list.get(i));
            }
        }

        int total=0;
        Integer dequeArr[] = deque.stream().toArray(Integer[]::new);
        for (int i=0; i<N; i++){
            int temp = deque.pollFirst();
            sb.append(temp).append(" ");
            total += dequeArr[i]*dequeArr[(i+1)%N];
        }
        System.out.println(total);
        System.out.println(sb.toString());  
    }
}