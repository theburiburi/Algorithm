import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=10; i++){
            int N = Integer.parseInt(br.readLine());

            sb.append("#"+N+" ");

            int arr[] = new int[8];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<8; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            rotate(arr);
            for(int i=0;i<8;i++){
                sb.append(arr[i]+" ");
            }
        }
        System.out.println(sb);
    }

    public static int[] rotate(int arr[]){

        while(true){
            int temp = arr[0];
            for(int i=1; i<=5; i++){
                for(int j=1; j<8; j++){
                    arr[j-1] = arr[j];
                }
                temp -= i;
                if(temp <= 0){
                    arr[7] = 0;
                    return arr;
                }
                else{
                    arr[7] = temp;
                }
            }
        }
    }
}
