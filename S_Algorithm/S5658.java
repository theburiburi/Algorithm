import java.io.*;
import java.util.*;

public class S5658{
    static StringBuilder sb;
    static int N, K;
    static char[] arr;
    static int ans;

    static Set<String> set;
    public static void main(String args[])throws IOException{
        readInput();
        System.out.println(sb.toString());
    }

    public static void readInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new char[N + N/4];
            String str = br.readLine();
            for(int i=0; i<N; i++){
                arr[i] = str.charAt(i);
            }
            set = new HashSet<>();
            
            sb.append("#").append(t).append(" ");
            solve();
        }
    }
    public static void solve(){
        StringBuilder sb2;
        int lineCnt = N/4; // 한줄의 갯수

        for(int i=0; i<lineCnt; i++){ // 회전
            arr[N+i] = arr[i];
            sb2 = new StringBuilder();
            int count = 1;
            for(int j=i; j<N+i; j++, count++){
                sb2.append(arr[j]);
                if(count % lineCnt == 0){
                    set.add(sb2.toString());
                    sb2 = new StringBuilder();
                }
            }
        }

        List<String> list = new ArrayList<>(set);
        list.sort((s1,s2) -> s2.compareTo(s1));
        sb.append(sixteenToTen(list.get(K-1))).append("\n");

    }
    public static int sixteenToTen(String str){
        int ans = 0;
        for(int i=0; i<str.length(); i++){
            char now = str.charAt(i);
            int num;
            if('A'<=now && now <='F'){
                num = now - 'A' + 10;
            }
            else{
                num = now - '0';
            }
            ans *= 16;
            ans += num;
        }
        return ans;
    }
}
