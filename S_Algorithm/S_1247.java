
import java.util.*;
import java.io.*;

class S_1247 //1247 dfs
{
    static int start[];
    static int end[];
    static int customer[];
    static int answer;
    static int N;
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
        	N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            start = new int[2];
            end = new int[2];
            customer = new int[N*2];
            boolean visited[] = new boolean[N];
            
            answer = Integer.MAX_VALUE;
            
            
            for(int i=0; i<2; i++) {
            	start[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0; i<2; i++) {
            	end[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0; i<N*2; i++){
            	customer[i] = Integer.parseInt(st.nextToken());
            }
            dfs(start[0], start[1], 0, 0, visited);
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int nowY, int nowX, int count, int total, boolean visited[]){
    	if(count == N) {
            int temp = total;
            temp += distance(nowY, nowX, end[0], end[1]);
    		answer = Math.min(answer, temp);
    		return;
    	}
        
        for(int i=0; i<N; i++){
            if(visited[i] == false){
            	visited[i] = true;
            	int nY = customer[i*2];
            	int nX = customer[i*2+1];
                dfs(nY, nX, count+1, total+distance(nowY, nowX, nY, nX), visited);
                visited[i] = false;
            }
        }
    }
    
    public static int distance(int y, int x, int laterY, int laterX){
        return Math.abs(y-laterY) + Math.abs(x-laterX);
    }
}
