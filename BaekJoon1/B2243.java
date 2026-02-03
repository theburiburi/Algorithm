import java.io.*;
import java.util.*;

public class B2243 {
    static int[] tree;
    static int treeSize = 1;
    static int maxSize = 1000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while(maxSize > treeSize){ treeSize *= 2;}
        tree = new int[treeSize * 2];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(A==1){
                int target = findTarget(1, 1, treeSize, B);
                sb.append(target).append("\n");
            }
            else{
                int C = Integer.parseInt(st.nextToken());
                update(1, 1, treeSize, B, C);
            }
        }
        System.out.print(sb.toString());
    }

    static int findTarget(int node, int start, int end, int value){
        tree[node] -= 1;

        if(start == end) return start;

        int mid = (start+end) / 2;
        if(tree[node*2] >= value){
            return findTarget(node*2, start, mid, value);
        }
        else{
            return findTarget(node*2+1, mid+1, end, value - tree[node*2]);
        }
    }

    static void update(int node, int start, int end, int target, int diff){
        if (target < start || target > end) return;
        tree[node] += diff;

        if(start != end){
            int mid = (start+end) / 2;
            update(node*2, start, mid, target, diff);
            update(node*2+1, mid+1, end, target, diff);
        }
    }
}

