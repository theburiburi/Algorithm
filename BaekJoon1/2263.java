import java.io.*;
import java.util.*;


public class 2263 { //2263
    static int inOrder[];
    static int postOrder[];
    static int inIdx[];
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1;
        StringTokenizer st2;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());

        inOrder = new int[N];
        inIdx = new int[N+1]; // 한 수 배웁니다.
        postOrder = new int[N];

        for(int i=0; i<N; i++){
            inOrder[i] = Integer.parseInt(st1.nextToken());
            inIdx[inOrder[i]] = i;
            postOrder[i] = Integer.parseInt(st2.nextToken());    
        }

        dfs(0, N-1, 0, N-1);
        System.out.println(sb.toString());
    }
    public static void dfs(int inStart, int inEnd, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd) return;//종료조건 만들기

        int root = postOrder[postEnd];
        int rootIdx = inIdx[root];

        sb.append(root + " ");

        int leftSize = rootIdx - inStart;
        dfs(inStart, rootIdx -1, postStart, postStart + leftSize -1);
        dfs(rootIdx+1, inEnd, postStart + leftSize, postEnd-1);
    }

    // public static int findMidleIdx(int num, int arr[]){
    //     for(int i=0; i<N; i++){
    //         if (num == arr[i]) return i;
    //     }

    //     return -1;
    // }
}

