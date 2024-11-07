import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{//11812 공통조상 찾기
    static long N;
    static int K, Q;
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Long.parseLong(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long ans;
            if(K == 1){
                ans = Math.abs(a-b);
            }
            else{
                ans = solution(a,b);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }
    static long solution(long a, long b){
        long ans = 0;
        long aDep = depth(a);
        long bDep = depth(b);
        if(aDep < bDep){
            long tempDep = aDep;
            long temp = a;
            aDep = bDep;
            bDep = tempDep;
            a = b;
            b = temp;
        }
        while(aDep != bDep){
            a = getParent(a);
            aDep--;
            ans++;
        }
        while(a != b){
            a = getParent(a);
            b = getParent(b);
            ans += 2;
        }

        return ans;
    }
    static long getParent(long a){
        return ((a+(K-2)) / K);
    }
    static long depth(long a){
        long dep=0;

        while(a != 1){
            a = getParent(a);
            dep++;
        }
        return dep;
    }
}