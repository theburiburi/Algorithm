import java.io.*;
import java.util.*;

public class B15823{
    static StringBuilder sb;
    static int N, M;
    static int arr[];
    
    static int num[];
    public static void main(String args[])throws IOException{
        inputFile();

    }
    static void inputFile()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int maxSize = N / M;
        int minSize = 1;
        num = new int[500_001];
        while(minSize <= maxSize){
            int mid = (maxSize + minSize)/2;
            //System.out.println("minSize: " + minSize + " maxSize: " + maxSize);
            if(solution(mid)){
                minSize = mid+1;
            }
            else{
                maxSize = mid-1;
            }
        }
        System.out.println(maxSize);
    }

    static boolean solution(int size){
        int left = 0;
        int count = 0;
        for(int right=0; right<N; right++){
            int now = arr[right];
            num[now]++;
            while(num[now] > 1){
                num[arr[left++]]--;
            }
            
            if(right-left+1 == size){
                while(left <= right){
                    num[arr[left++]]--;
                }
                count++;
            }

            if(count >= M){
                cleanup(left, right);
                return true;
            }
        }

        cleanup(left, N-1);
        return false;
    }
    static void cleanup(int left, int right) {
        // for (int i = left; i <= Math.min(right, N - 1); i++) {
        //     if (num[arr[i]] > 0) {
        //         num[arr[i]]--;
        //     }
        // }
        while(left <= right){
            num[arr[left++]]--;
        }
    }
}
