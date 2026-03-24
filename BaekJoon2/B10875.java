import java.io.*;
import java.util.*;

public class B10875 {
    static int L, N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Line {
        int x1, y1, x2, y2;
        int minX, maxX, minY, maxY;
        boolean isVertical;

        public Line(int x1, int y1, int x2, int y2) {
            this.x1 = x1; this.y1 = y1;
            this.x2 = x2; this.y2 = y2;
            this.minX = Math.min(x1, x2);
            this.maxX = Math.max(x1, x2);
            this.minY = Math.min(y1, y2);
            this.maxY = Math.max(y1, y2);
            this.isVertical = (x1 == x2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        List<Line> lines = new ArrayList<>();
        int nowX = 0, nowY = 0;
        int nowDir = 0;
        long totalTime = 0;

        for (int i = 0; i <= N; i++) {
            int t = 0;
            char turn = ' ';

            if (i < N) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                t = Integer.parseInt(st.nextToken());
                turn = st.nextToken().charAt(0);
            } else {
                t = 2 * L + 1;
            }

            int minHit = t + 1;
            if (nowDir == 0) minHit = Math.min(minHit, L - nowX + 1);
            else if (nowDir == 1) minHit = Math.min(minHit, L - nowY + 1);
            else if (nowDir == 2) minHit = Math.min(minHit, nowX - (-L) + 1);
            else if (nowDir == 3) minHit = Math.min(minHit, nowY - (-L) + 1);

            for (Line target : lines) {
                int dist = getDist(nowX, nowY, nowDir, target);
                if (dist != -1) minHit = Math.min(minHit, dist);
            }

            if (minHit <= t) {
                System.out.println(totalTime + minHit);
                return;
            }

            int nextX = nowX + dx[nowDir] * t;
            int nextY = nowY + dy[nowDir] * t;
            lines.add(new Line(nowX, nowY, nextX, nextY));
            totalTime += t;
            nowX = nextX;
            nowY = nextY;

            if (turn == 'L') nowDir = (nowDir + 1) % 4;
            else if (turn == 'R') nowDir = (nowDir + 3) % 4;
        }
    }

    static int getDist(int x, int y, int dir, Line target) {
        if (dir == 0) {
            if (target.isVertical) {
                if (target.minY <= y && y <= target.maxY && target.x1 > x) return target.x1 - x;
            } else {
                if (y == target.y1 && target.minX > x) return target.minX - x;
            }
        } else if (dir == 1) {
            if (!target.isVertical) {
                if (target.minX <= x && x <= target.maxX && target.y1 > y) return target.y1 - y;
            } else {
                if (x == target.x1 && target.minY > y) return target.minY - y;
            }
        } else if (dir == 2) {
            if (target.isVertical) {
                if (target.minY <= y && y <= target.maxY && target.x1 < x) return x - target.x1;
            } else {
                if (y == target.y1 && target.maxX < x) return x - target.maxX;
            }
        } else if (dir == 3) {
            if (!target.isVertical) {
                if (target.minX <= x && x <= target.maxX && target.y1 < y) return y - target.y1;
            } else {
                if (x == target.x1 && target.maxY < y) return y - target.maxY;
            }
        }
        return -1;
    }
}