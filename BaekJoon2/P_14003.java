import java.io.*;
import java.util.*;

public class P_14003 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int arrIdx[] = new int[N];
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            int size = list.size();

            if(list.isEmpty() || list.get(size-1) < arr[i]){
                list.add(arr[i]);
                arrIdx[i] = size;
            }
            else{
                int position = findIdx(list, arr[i]);
                list.set(position, arr[i]);
                arrIdx[i] = position;
            }
        }


        sb.append(list.size()+"\n");

        Stack<Integer> stack = new Stack<>();
        int ansIdx = list.size()-1;
        for(int i=N-1; i>=0; i--){
            if(arrIdx[i] == ansIdx){
                stack.add(arr[i]);
                ansIdx--;
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb);
    }

    public static int findIdx(List<Integer> list, int target){
        int left = 0;
        int right = list.size()-1;

        while(left <= right){
            int mid = (left+right)/2;
            if(list.get(mid) < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return left;
    }
}