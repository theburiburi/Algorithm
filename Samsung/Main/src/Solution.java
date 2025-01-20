import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("sample_input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        UserSolution userSolution = new UserSolution();

        for (int t = 1; t <= T; t++) {
            // 보물상자 전체 지도 크기와 조각 지도 크기 읽기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 보물상자 전체 지도 읽기
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // init 메서드 호출
            userSolution.init(N, M, map);

            // 보물상자 조각 지도 읽기
            int[][] pieces = new int[M][M];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    pieces[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // findTreasureChest 메서드 호출
            UserSolution.Result result = userSolution.findTreasureChest(pieces);

            // 결과 출력
            bw.write("#" + t + " " + result.x + " " + result.y + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
