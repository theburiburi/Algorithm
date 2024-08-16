import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Node {
    int P;
    int L;

    public Node(int P, int L){
        this.P = P;
        this.L = L;
    }
}

public class 21939{ //자료구조
    static int N;
    static int M;
    static TreeSet<Node> ts;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        ts = new TreeSet<>((o1, o2)-> {
            if(o1.L == o2.L) return o1.P - o2.P;
            else{
                return o1.L - o2.L;
            }
        });

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            Node temp = new Node(P,L);
            ts.add(temp);
            map.put(P, L);
        }
        M = Integer.parseInt(br.readLine());
        for (int i=0; i<M; i++){
            String problem[] = br.readLine().split(" ");
            int tempP = Integer.parseInt(problem[1]);
            int tempL = Integer.parseInt(problem[problem.length-1]);
            switch(problem[0]){
                case "add":
                    ts.add(new Node(tempP, tempL));
                    map.put(tempP, tempL);
                    break;
                case "recommend":
                    if (tempP == 1){
                        sb.append(ts.last().P + "\n");
                    }
                    else if (tempP == -1){
                        sb.append(ts.first().P + "\n");
                    }
                    break;
                case "solved":
                    int removeL = map.get(tempP);
                    ts.remove(new Node(tempP, removeL));
                default: 
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}