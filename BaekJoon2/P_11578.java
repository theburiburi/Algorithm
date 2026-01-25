import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class P_11578{//11578 Î∏åÎ£®?∏Ìè¨??Î∞±Ìä∏?òÌÇπ
    static int M, N;
    static ArrayList<Integer> addArr[];
    static ArrayList<Integer> containArr;
    static int answer = Integer.MAX_VALUE;
    static int sumArr=0;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        addArr = new ArrayList[M];
        containArr = new ArrayList<>();
        for(int i=0; i<M; i++){
            addArr[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int O = Integer.parseInt(st.nextToken());
            for (int j=0; j<O; j++){
                addArr[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        sumArr = N * (N + 1) / 2;

        dfs(0 ,0);
        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
        }
    }

    static void dfs(int num ,int depth){
        if(depth == M){
            Set<Integer> set = new HashSet<Integer>(containArr);
            int sum = 0;
            for(int temp : set){
                sum += temp;
            }
            if(sumArr == sum){
                answer = Math.min(num, answer);
            }
            return;
        }
        
        dfs(num ,depth+1);
        for (int temp: addArr[depth]){
            containArr.add(temp);
        }
        dfs(num+1 ,depth+1);
        for (int temp : addArr[depth]) {
            containArr.remove(Integer.valueOf(temp)); // containArr?êÏÑú ?†ÌÉù?àÎçò Î¨∏Ï†úÎ•??úÍ±∞??
        }
    }
}
