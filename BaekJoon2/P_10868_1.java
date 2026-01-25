import java.io.*;
import java.util.*;

public class P_10868_1 { // 10868 Segment Tree // Bottom-up
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int size = 1; //ë¦¬í”„ ?¸ë“œ ê°?ˆ˜
        while(size < N) size *= 2;
        int tree[] = new int[size*2];

        for(int i=0; i<size; i++){
            if(i < N) tree[size+i] = Integer.parseInt(br.readLine());
            else tree[size+i] = Integer.MAX_VALUE;
        }

        for(int i=size-1; i > 0; i--){
            tree[i] = Math.min(tree[i*2], tree[i*2+1]);
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) + size - 1;
            int right = Integer.parseInt(st.nextToken()) + size - 1;

            int answer = Integer.MAX_VALUE;
            while(left <= right){
                if(left % 2 == 1) answer = Math.min(answer, tree[left++]);
                if(right % 2 == 0) answer = Math.min(answer, tree[right--]);
                left /= 2;
                right /= 2;
            }
            sb.append(answer+"\n");
        }
        System.out.println(sb);
    }
}
