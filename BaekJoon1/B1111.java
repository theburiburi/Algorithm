import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1111{////1111 ?˜í•™
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        int a,b;
        boolean check = true;
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(N == 1){
            System.out.println("A");
        }
        else if(N == 2 && arr[0]!=arr[1]){
            System.out.println("A");
        }
        else if(N == 2){
            System.out.println(arr[0]);
        }
        else{
            if(arr[0]==arr[1]){
                a=1;
                b=0;
            }
            else{
                a = (arr[2]-arr[1]) / (arr[1]-arr[0]);
                b = (arr[2]-(a*arr[1]));
            }

            for(int i=0; i<N-1; i++){
                if(arr[i]*a+b != arr[i+1]){
                    System.out.println("B");
                    check = false;
                    break;
                }
            }
            if(check){
                System.out.println(arr[N-1]*a + b);
            }
        }
    }
}
