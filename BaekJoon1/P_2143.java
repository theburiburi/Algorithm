import java.io.*;
import java.util.*;

public class P_2143 { //2143 ?´ì‰¬
    static int T, n, m;;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        n = Integer.parseInt(br.readLine());
        int A[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = Integer.parseInt(br.readLine());
        int B[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();;


        Map<Integer, Integer> mapA = new HashMap<>();
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += A[j];
                mapA.put(sum, mapA.getOrDefault(sum, 0)+1);
            }
        }

        long ans = 0;
        for(int i=0; i<m; i++){
            int sum = 0;
            for(int j=i; j<m; j++){
                sum += B[j];
                int key = T-sum;
                if(mapA.containsKey(key)){
                    ans += mapA.get(key);
                }
            }
        }
        System.out.println(ans);
    }
}

