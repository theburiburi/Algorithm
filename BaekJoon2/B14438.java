import java.util.*;
import java.io.*;

public class B14438 {
    static int N, M;
    static int[] arr, tree;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        inputFile();
        System.out.println(sb.toString().trim());
    }

    public static void inputFile() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        
        int size = 1;
        while(size < N){
            size <<= 1;
        }
        size <<= 1;
        tree = new int[size];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        makeTree(1,1,N);

        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if(type == 1){
                changeVal(1, left, right, 1, N);
            }
            else{ // 2
                sb.append(findNode(1, 1, N, left, right)).append("\n");
            }
        }
    }
    static int findNode(int node, int start, int end, int left, int right){
        if(end < left || right < start){
            return Integer.MAX_VALUE;
        }
        if(left <= start && end <= right){
            return tree[node];
        }

        int mid = (start+end)/2;
        int lNum = findNode(node*2, start, mid, left, right);
        int rNum = findNode(node*2+1, mid+1, end, left, right);

        return Math.min(lNum, rNum);
    }

    static void makeTree(int node, int start, int end){
        if(start == end){
            tree[node] = arr[start];
            return;
        }
        
        int mid = (start + end) / 2;
        makeTree(node*2, start, mid);
        makeTree(node*2+1, mid+1, end);

        tree[node] = Math.min(tree[node*2], tree[node*2+1]);
    }

    static void changeVal(int node, int idx, int val, int start, int end){
        if(end < idx || idx < start){
            return;
        }
        if(start == end){
            tree[node] = val;
            return;
        }

        int mid = (start+end)/2;
        changeVal(node*2, idx, val, start, mid); 
        changeVal(node*2+1, idx, val, mid+1, end);
        tree[node] = Math.min(tree[node*2], tree[node*2+1]);
    }
}
