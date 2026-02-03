import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class B2233{//2233 ?€ë¦?
    static int N;
    static List<Integer> list[];
    static int pair[];
    static boolean visited[];
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N];
        pair = new int[N]; //output
        visited = new boolean[N];
        int index[] = new int[2*N]; //input
        
        for(int i=0; i<N; i++){
            list[i] = new ArrayList<>();
        }
        Stack<Integer> stack = new Stack<>();
        String sentence = br.readLine();

        
        int count=0;
        int listCount = 0;
        for(int i=0; i<sentence.length(); i++){
            char temp = sentence.charAt(i);
            
            if(temp=='0'){
                stack.add(count);
                index[i] = count;
                if(i!=0){
                    list[count].add(listCount);
                    listCount++;
                }
                count++;
            }
            else{
                int stackTemp = stack.pop();
                pair[stackTemp] = i;
                index[i] = stackTemp;
                listCount--;
            }
        }

        String temp = br.readLine();
        int decay[] = new int[2];
        decay[0] = temp.charAt(0) - '0' -1;
        decay[1] = temp.charAt(2) - '0' -1;

        decay[0] = index[decay[0]];
        decay[1] = index[decay[1]];
        visited[0] = true;
        int ans;
        ans = dfs(decay[0]);
        ans = dfs(decay[1]);

        System.out.println(ans+1+" "+(pair[ans]+1));
    }
    static int dfs(int decay){ // rootê¹Œì? dfs
        if(visited[decay]){
            return decay;
        }
        else{
            visited[decay] = true;
            return dfs(list[decay].get(0));
        }
    }
}
