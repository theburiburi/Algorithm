import java.io.*;
import java.util.*;

public class 1184 { //1184
    static int N;
    static int S[][];
    static final int maxValue = 2500000;
    static int countArr[] = new int[maxValue*2+1];
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        N = Integer.parseInt(br.readLine());
        S = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int temp = Integer.parseInt(st.nextToken());
                S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + temp;
            }
        }

        int answer = 0;
        for(int i=1; i<N; i++){
            for(int j=1; j<=N; j++){         
                if(j < N){
                    //왼쪽 위
                    for(int r = 1; r<=i; r++){
                        for(int c =1; c<=j; c++){
                            int temp = getWidth(i, j, r, c) + maxValue;
                            countArr[temp]++;
                        }
                    }
                    //오른쪽 아래
                    for(int r = i+1; r<=N; r++){
                        for(int c=j+1; c<=N; c++){
                            int temp = getWidth(r, c, i+1, j+1) + maxValue;
                            answer += countArr[temp];
                        }
                    }

                    reset(i, j, 1);
                }

                if(j > 1){
                    //오른쪽 위
                    for(int r = 1; r<=i; r++){
                        for(int c=j; c<=N; c++){
                            int temp = getWidth(i, c, r, j) + maxValue;
                            countArr[temp]++;
                        }
                    }
                    //왼쪽 아래
                    for(int r = i+1; r<=N; r++){
                        for(int c=1; c<j; c++){
                            int temp = getWidth(r, j-1, i+1, c) + maxValue;
                            answer += countArr[temp];
                        }
                    }
                    reset(i, j, 2);
                }
            }
        }
    System.out.println(answer);
    }

    public static int getWidth(int i, int j, int y, int x){
        return S[i][j] - S[y-1][j] - S[i][x-1] + S[y-1][x-1];
    }

    public static void reset(int i, int j, int type){
        if (type == 1) { // 왼쪽 위
            for (int r = 1; r <= i; r++) {
                for (int c = 1; c <= j; c++) {
                    countArr[getWidth(i, j, r, c) + maxValue] = 0;
                }
            }
        } 
        else { // 오른쪽 위
            for (int r = 1; r <= i; r++) {
                for (int c = j; c <= N; c++) {
                    countArr[getWidth(i, c, r, j) + maxValue] = 0;
                }
            }
        }
    }
}
