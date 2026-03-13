import java.io.*;

public class B14728{
    static int N, T;
    static int dp[];
    public static void main(String args[])throws IOException{
        inputFile();
    }
    static void inputFile()throws IOException{
        N = read();
        T = read();

        dp = new int[T+1];
        for(int i=0; i<N; i++){
            int time = read();
            int score = read();

            for(int t=T; t>=time; t--){
                int currentScore = dp[t - time] + score;
                if (currentScore > dp[t]) {
                    dp[t] = currentScore;
                }
            }
        }

        System.out.println(dp[T]);
    }

    static int read() throws IOException{
        int c;
        while ((c = System.in.read()) <= 32) { }
        
        int n = c & 15;
        while((c = System.in.read()) > 32){
            n = (n<<3) + (n<<1) + (c & 15);
        }
        return n;
    }
}