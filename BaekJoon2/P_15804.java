import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P_15804 {//15804 deque
    public static class bus{
        int t;
        int p;
        int idx;
        
        public bus(int t, int p, int idx) {
            this.t = t;
            this.p = p;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Deque<bus> dq = new ArrayDeque<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty()) {
                if (dq.peekFirst().p <= t) dq.pollFirst();
                else break;
            }

            if (dq.isEmpty()) {  //ë¹„ì–´?ˆì„ ???£ê¸°
                dq.offerLast(new bus(t, t + p, 1));
            } 
            else if (dq.peekLast().idx == N) { // ê½?ì°¼ì„ ????ë¹¼ê¸°
                while (!dq.isEmpty()) {
                    t = Math.max(t, dq.peekFirst().p);
                    dq.pollFirst();
                }
                dq.offerLast(new bus(t, t + p, 1));
            } 
            else { //ë¹„ì–´?ˆì? ?Šì„ ???¤ìŒ ?œì„œë¡??£ê¸°
                t = Math.max(t, dq.peekLast().t);
                dq.offerLast(new bus(t, t + p, dq.peekLast().idx + 1));
            }
        }

        System.out.println(dq.peekLast().idx);
    }
}
