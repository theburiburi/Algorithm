import java.io.*;
import java.util.*;

public class S_1959 {

    public static void main(String[] args) throws IOException { 
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int A[] = new int[N];
            int B[] = new int[M];

            for(int j=0; j<N; j++){
                A[j] = sc.nextInt();
            }
            
            for(int j=0; j<M; j++){
                B[j] = sc.nextInt();
            }
            int answer = 0;

            if(N<M){
                answer = solution(N, M, A, B);
            }
            else{
                answer = solution(M, N, B, A);
            }
            sb.append("#"+i+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    public static int solution(int small, int big, int sArr[], int bArr[]){
        int gap = big - small + 1;
        int answer = Integer.MIN_VALUE;

        for(int i=0; i<gap; i++){
            int temp = 0;
            for(int j=0; j<small; j++){
                temp += sArr[j] * bArr[i+j];
            }
            if (answer < temp) answer = temp;
        }
        return answer;
    }
}

