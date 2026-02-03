import java.io.*;
import java.util.*;

public class B6137 { //6137 string
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        List<Character> list = new ArrayList<>();
        char arr[] = new char[N];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine().charAt(0);
        }
        int left = 0;
        int right = N-1;
        while(left <= right){
            if(arr[left] < arr[right]){
                list.add(arr[left++]);
            }
            else if(arr[left] == arr[right]){
                int front = left;
                int back = right;
                boolean check=false;

                while(arr[front]==arr[back]){
                    if (front < back) front++;
                    if (back > front) back--;

                    if(arr[front] < arr[back]) check=true;
                    if(arr[front] > arr[back]) check=false;
                    if (front == back) break;
                }
                if(check) list.add(arr[left++]);
                else list.add(arr[right--]);
            }
            else{
                list.add(arr[right--]);
            }
        }
        for(int i=0; i<list.size(); i++){
            if(i!=0 &&i%80==0){
                sb.append("\n");
            }
            sb.append(list.get(i));
        }
        System.out.println(sb.toString());
    }
}

