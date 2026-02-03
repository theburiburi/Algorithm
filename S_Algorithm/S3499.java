import java.io.*;
import java.util.*;

public class S3499 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            sb.append("#"+t+" ");
            int N = Integer.parseInt(br.readLine());
            Queue<String> left = new LinkedList<>();
            Queue<String> right = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                if(i < (N+1)/2){
                    left.add(st.nextToken());
                }
                else{
                    right.add(st.nextToken());
                }
            }
            
            while(!right.isEmpty()){
                sb.append(left.poll()+" ").append(right.poll()+" ");
            }
            if(!left.isEmpty()){
                sb.append(left.poll()+ " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
