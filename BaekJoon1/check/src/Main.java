import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
public class Main{
    static int N;
    static int answer = 0;
    static int arr[][];
    static int ining = 0;
    static int score[];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            arr = new int[N][9];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            score = new int[10];

            st = new StringTokenizer(br.readLine());
            for (int j=0; j<9; j++){
                if(j==0){
                    arr[i][3] = Integer.parseInt(st.nextToken());
                }
                pq.add(Integer.parseInt(st.nextToken()));
            }

            while(true){ //0을 제외하고 숫자부터 추출하기 위한 작업
                int temp = pq.peek();
                if(temp == 0){
                    pq.poll();
                }
                else{
                    break;
                }
            }
            int k = ining;
            while(pq.size()>0){ //첫 타자부터 1안타부터 채우기
                arr[i][k++] = pq.poll();
                if(k==3) {k++;}
            }
            int count = 0; //3아웃 체크를 위해
            int scoreNum = 1;
            while(count < 3){
                if(arr[i][ining] == 0){
                    count++;
                }
                else{
                    for (int q=0; q<scoreNum; q++){
                        score[ining] += arr[i][ining];
                    }
                    if(scoreNum < 10){
                        scoreNum++;
                    }
                   for(int q=0; q<10; q++){
                    if(score[q] >= 4){
                        score[q] = 0;
                        answer++;
                    }
                   }
                }

                if(++ining == 10) {ining = 0;} //다음 타자
            }
        }
    }
}