import java.io.*;
import java.util.*;

public class Main { //2287 treeset
    static int K;
    static int arr[];
    static HashSet<Integer> dp[] = new HashSet[9];
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }
        int num = 0;

        for(int i=1; i<=8; i++){
            dp[i] = new HashSet<>();
            num = num*10 + K;
            dp[i].add(num);
        }
        solution();
        
        for(int i=0; i<n; i++){
            int ans = 0;
            for(int j=1; j<=8; j++){
                if(dp[j].contains(arr[i])){
                    ans = j;
                    break;
                }
            }
            sb.append(ans == 0 ? "NO" : ans + "\n");
        }
        System.out.print(sb.toString().trim());
    }
    public static void solution(){
        for(int i=1; i<=8; i++){
            for(int j=1; j<=i/2; j++){
                int idx = i-j;
                for(int a : dp[j]){
                    for(int b : dp[idx]){
                        dp[i].add(a+b);
                        dp[i].add(a-b);
                        dp[i].add(b-a);
                        dp[i].add(a*b);
    
                        if(a!=0){dp[i].add(b/a);}
                        if(b!=0){dp[i].add(a/b);}
                    }
                }
            }
        }
    }
}

