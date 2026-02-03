import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1206{//1206 브루?�포??
    static int N;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        for (int i=0; i<N; i++){
            String[] input = br.readLine().split("\\."); 
            StringBuilder sb = new StringBuilder();
            sb.append(input[0]).append(input[1]);
            arr[i] = Integer.parseInt(sb.toString());
        }

        for (int i=1; i<=1000; i++){
            if(isPossible(i, arr)){
                System.out.println(i);
                break;
            }
        }
    }
    static boolean isPossible(int num, int[] aver){
        for (int tempAver : aver){
            int mini = 0;
            int maxi = num * 10;
            boolean check = false;
            while(mini <= maxi){
                int mid = (mini + maxi) / 2; 
                int now = mid*1000 / num;

                if(tempAver == now){
                    if(now > 10 * 1000){
                        continue;
                    }
                    check = true;
                    break;
                }
                else if(tempAver < now){
                    maxi = mid-1;
                }
                else{
                    mini = mid+1;
                }
            }
            if(!check) return false;
        }
        return true;
    }
}
