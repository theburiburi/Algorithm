import java.io.*;
import java.util.*;

public class B9849 { //9489
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if(n == 0 && k==0) break;

            int arr[] = new int[n];
            int parent[] = new int[n];
            int kIdx = -1;

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] == k) kIdx = i;
            }

            parent[0] = -1;
            int parentIdx = -1;
            for(int i=1; i<n; i++){
                if(arr[i] != arr[i-1]+1){
                    parentIdx++;
                }
                parent[i] = parentIdx;
            }


            int ans = 0;
            if(kIdx > 0 && parent[kIdx] > 0){
                int ansGrantParentIdx = parent[parent[kIdx]];
                int ansParentIdx = parent[kIdx];
                for(int i=1; i<n; i++){
                    if(parent[parent[i]] == ansGrantParentIdx && parent[i] != ansParentIdx){
                        ans++;
                    }
                }
            }

            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}

