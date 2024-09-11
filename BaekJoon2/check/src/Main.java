import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main{
    static int N;
    static int answer = 0;
    static int time = 0;
    static int playerScore[][];

    static boolean checkPlayer[];
    static int orderNum[];
    static boolean currentState[];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        playerScore = new int[N][9];
        checkPlayer = new boolean[9];
        orderNum = new int[9];
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " "); // 새로배운 표현
            for (int j=0; j<9; j++){
                playerScore[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        checkPlayer[3] = true;
        orderNum[3] = 0;

        makeNum(1);
        System.out.println(answer);

    }
    static void makeNum(int num){
        if(num == 9){
            int score = getScore();
            answer = Math.max(answer, score);
            return;
        }
        for(int i=0; i<9; i++){
            if(!checkPlayer[i]){
                checkPlayer[i] = true;
                orderNum[i] = num;
                makeNum(num+1);
                checkPlayer[i] = false;
            }
        }
    }
    static int getScore(){
        int ans=0;
        time = 0;
        for(int i=0; i<N; i++){
            currentState = new boolean[4];
            int out = 0; //3아웃 체크용
            while(out < 3){
                int batter = orderNum[time];
                if(playerScore[i][batter] == 0){
                    out++;
                }
                else{
                    ans += moveRunner(playerScore[i][batter]);
                }
                if(++time >= 9) {time = 0;} //0번째 타자부터 다시
            }
        }
        return ans;
    }
    static int moveRunner(int hitScore){
        int runs = 0;
        currentState[0] = true;

        for(int i=3; i>=0; i--){
            if(currentState[i]){
                int base = i+hitScore;
                if(base>=4){
                    runs++;                    
                }
                else{
                    currentState[base] = true;
                }        
                currentState[i] = false;
            }
        }
        return runs;
    }
}