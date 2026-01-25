import java.io.*;
import java.util.*;

public class 10868_2 { //segment tree Top-down 방식
    static int tree[];
    static int arr[];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int size = 1;

        while(size < N) size *= 2;

        arr = new int[N+1];
        tree = new int[size*2];
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        setting(1, 1, N);
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            sb.append(find(1, 1, N, left, right) + "\n");
        }
        System.out.println(sb);
    }
    private static int setting(int node, int start, int end){
        if(start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;

        return tree[node] = Math.min(setting(node*2, start, mid), setting(node*2+1, mid+1, end));
    }

    private static int find(int node, int start, int end, int left, int right){
        if(end < left || right < start) return Integer.MAX_VALUE; // 완전 벗어날 때

        if(left <= start && end <= right) return tree[node]; //범위 안 일때

        int mid = (start + end) / 2;
        return Math.min(find(node*2, start, mid, left, right), find(node*2+1, mid+1, end, left, right)); // 일부분 겹쳐 있을 때
    }
}
