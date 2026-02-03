import java.io.*;
import java.util.*;

public class B1943 { //dp
    static class Node {
        int coin;
        int count;

        public Node(int coin, int count) {
            this.coin = coin;
            this.count = count;
        }
    }

    public static void main(String args[]) throws IOException { //1943
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        for (int i = 0; i < 3; i++) {
            List<Node> list = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            int total = 0;
            boolean check = true;
            boolean dp[] = new boolean[100001];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int coin = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                list.add(new Node(coin, count));
                total += coin * count;
            }

            if (total % 2 != 0) {
                bw.write("0\n");
                continue;
            }

            int target = total / 2;
            list.sort((s1, s2) -> s2.coin - s1.coin);

            dp[0] = true;
            for (Node now : list) {
                for(int j=target; j>=0; j--){
                    if(dp[j]==true){
                        for(int k=1; k<=now.count; k++){
                            dp[j+k*now.coin] = true;
                        }
                    }
                    if(dp[target]==true) break;
                }
                if(dp[target]==true) break;
            }

            if (dp[target]==true) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }
        bw.flush();
    }
}

