import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2828{
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int time = Integer.parseInt(br.readLine());
        
        int buckLeft = 1;
        int buckRight = M;

        int distance = 0;

        int arr[] = new int[time];

        for (int i=0; i < time; i++)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < time; i++)
        {
            int buffer = 0;
            if (buckRight < arr[i])
            {
                buffer = arr[i] - buckRight;
                buckLeft = arr[i] - (M-1);
                buckRight = arr[i];
            }
            else if(buckLeft > arr[i])
            {
                buffer = buckLeft - arr[i];
                buckLeft = arr[i];
                buckRight = arr[i] + (M-1);
            }
            distance += buffer;
        }

        System.out.println(distance);

    }
}

