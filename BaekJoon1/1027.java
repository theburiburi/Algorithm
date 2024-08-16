import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{ //1027 완전탐색
    
    static int height[];
    static int N;

    public static int visible(int location)
    {
        double slopeLeft = Integer.MAX_VALUE;
        double slopeRight = Integer.MIN_VALUE;
        int count = 0;
        
        for(int i = location - 1; i >= 0; i--) //왼쪽 기울기 감소
        {
            double temp = (height[location] - height[i]) / (double)(location - i);
            if (slopeLeft > temp)
            {
                slopeLeft = temp;
                count++;
            }
        }
        for(int i = location + 1; i < N; i++) // 오른쪽 기울기 증가
        {
            double temp = (height[i] - height[location]) / (double)(i - location); 
            if (slopeRight < temp)
            {
                slopeRight = temp;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    height = new int[N];
    st = new StringTokenizer(br.readLine());
    
    for (int i=0; i < N; i++)
        height[i] = Integer.parseInt(st.nextToken());

    int answer = 0;
    for (int i=0; i < N; i++)
        answer = Integer.max(answer, visible(i));

    System.out.println(answer);
    }
}