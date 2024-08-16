import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{ //3216
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        int music = 0;
        int download = 0;
        for (int i=0; i < N; i++)
        {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if (i == 0)
            {
                music = D;
                answer += V;
                continue;
            }
            if (music - V < 0)
            {
                answer += (V - music);
                music += (V - music);
            }

            music += D;
            music -= V;
        }
        System.out.println(answer);
    }
}
