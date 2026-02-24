import java.io.*;
import java.util.*;

public class B4256{
    static StringBuilder sb;
    static int N;
    static int[] preorder, inorder;
    static boolean visited[];
    static Map<Integer, Integer> preIdxMap;
    static Map<Integer, Integer> inIdxMap;

    static int idx;
    public static void main(String args[])throws IOException{
        inputFile();
    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        sb = new StringBuilder();
        for(int t=0; t<T; t++){            
            N = Integer.parseInt(br.readLine());

            preorder = new int[N];
            inorder = new int[N];
            visited = new boolean[N];

            preIdxMap = new HashMap<>();
            inIdxMap = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                preorder[i] = Integer.parseInt(st.nextToken());
                preIdxMap.put(preorder[i], i);
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                inorder[i] = Integer.parseInt(st.nextToken());
                inIdxMap.put(inorder[i], i);
            }

            idx = -1;
            dfs(0, N-1);
            sb.append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }

    public static void dfs(int start, int end){
        if(start > end){ return ;}

        idx++;
        int index = idx;
        int midIdx = inIdxMap.get(preorder[index]); //
        dfs(start, midIdx-1);
        dfs(midIdx+1, end);

        sb.append(preorder[index]).append(" ");
    }
}
