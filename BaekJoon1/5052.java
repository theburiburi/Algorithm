import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class 5052{//5052 트리 트라이
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            String arr[] = new String[N];
            for(int j=0; j<N; j++){
                arr[j] = br.readLine();
            }
            Arrays.sort(arr);
            if(consistency(arr)) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb.toString());
    }
    static boolean consistency(String[] arr){
        boolean check = true;
        int arrLen = arr.length;
        for(int i=1; i<arrLen; i++){
            if(arr[i].startsWith(arr[i-1])){
                check = false;
            }
        }

        return check;
    }
}