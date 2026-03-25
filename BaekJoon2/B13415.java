import java.io.*;
import java.util.*;

public class B13415{
    static StringBuilder sb;
    static int N, K, A, B;
    static int[] arr;
    static Deque<int[]> deq;
    public static void main(String args[])throws IOException{
        inputFile();
        solve();
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());
        deq = new ArrayDeque<>();
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            deqAdd(a, 1);
            deqAdd(b, 0);
        }
        deq.addLast(new int[]{0,0});
    }

    static void solve(){
        int sorted[] = new int[deq.peekFirst()[0]];
        System.arraycopy(arr, 0, sorted, 0, deq.peekFirst()[0]);
        Arrays.sort(sorted);

        int L = 0;
        int R = deq.peekFirst()[0] - 1;
        int targetIdx = R;

        while(deq.size() > 1){
            int now[] = deq.pollFirst();
            int nextRange = deq.peekFirst()[0];

            int diff = now[0] - nextRange;
            for(int i=0;i <diff; i++){
                if(now[1] == 1){
                    arr[targetIdx--] = sorted[R--];  
                }
                else{
                    arr[targetIdx--] = sorted[L++];
                }
            }
        }

        sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    static void deqAdd(int num, int isRise){
        while(!deq.isEmpty() && deq.peekLast()[0] <= num){
            deq.pollLast();
        }
        deq.addLast(new int[]{num, isRise});
    }
}
