import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 3584{//3584 최초 공통조상
    static List<Integer> list[];
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int findX=0 , findY=0;
            list = new ArrayList[N+1];
            for(int j=1; j<=N; j++){
                list[j] = new ArrayList<>();
            }
            for(int j=0; j<N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(j==N-1){
                    findX = a;
                    findY = b;
                }
                else{
                    list[b].add(a);
                }
            }
            int depX = dfs(findX, 1);
            int depY = dfs(findY, 1);

            sb.append(find(depX, depY, findX, findY)).append("\n");
        }
        System.out.println(sb.toString());
    }
    static int dfs(int index, int count){
        if(list[index].size() == 0){
            return count;
        }
        else{
            return dfs(list[index].get(0) ,count+1);
        }
    }
    static int find(int depX, int depY, int findX, int findY){
        if(depX < depY){
            return find(depX, depY-1, findX, list[findY].get(0));
        }
        else if(depX > depY){
            return find(depX-1, depY, list[findX].get(0), findY);
        }
        else{
            if (findX == findY){
                return findX;
            }
            else{
                int tempX = list[findX].get(0);
                int tempY = list[findY].get(0);
                return find(depX-1, depY-1, tempX, tempY);
            }
        }
    }
}

