import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.LinkedList;
import java.util.Queue;

public class P_2468{  //2468 bfs
    static int N;
    static int maxHeight;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int arr[][];
    static boolean visited[][];

    public static boolean possible(int i,int j)
    {
        if ((0 <= i && i < N))
        {
            if (0 <= j && j < N)
            {
                if (visited[i][j] == false)
                    return true;
            }
        }
        return false;
    }

    public static void bfs(int i, int j, int height)
    {
        Queue <int[]> q = new LinkedList <int[]>();
        q.offer(new int[] {i,j});
        visited[i][j] = true;

        while(!q.isEmpty())
        {
            int[] data = q.poll();
            int y = data[0];
            int x = data[1];
            for (int k=0; k < 4; k++)
            {
                if (possible(y+dy[k], x+dx[k]) && arr[y+dy[k]][x+dx[k]] > height)
                {
                    q.offer(new int[] {y+dy[k], x+dx[k]});
                    visited[y+dy[k]][x+dx[k]] = true;
                }
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        
        
        maxHeight = 0;
        int answer = 0;
        int temp = 0;
        for(int i = 0; i < N; i++) // 초기?�팅
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (maxHeight < arr[i][j])
                    maxHeight = arr[i][j];
            }
        }

        for (int k = 0; k <= maxHeight; k++)
        {
            temp = 0;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < N; j++)
                {
                    if (possible (i,j) == true && arr[i][j] > k)
                    {
                        bfs(i, j, k);
                        temp += 1;
                    }
                }
            }
            answer = temp < answer ? answer : temp;
        }
        System.out.println(answer);
    }
}

