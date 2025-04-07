import java.io.*;
import java.util.*;

public class 9015 { //9015 해쉬셋
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return x == p.x && y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Point[] points = new Point[N];
            HashSet<Point> pointsSet = new HashSet<>();
            int ans = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[i] = new Point(x, y);
                pointsSet.add(points[i]);
            }

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    Point p1 = points[i];
                    Point p2 = points[j];

                    int dx = p2.x - p1.x;
                    int dy = p2.y - p1.y;
                    int len = dx * dx + dy * dy;

                    // 90도 회전
                    int x3 = p1.x - dy;
                    int y3 = p1.y + dx;
                    int x4 = p2.x - dy;
                    int y4 = p2.y + dx;

                    if (pointsSet.contains(new Point(x3, y3)) && pointsSet.contains(new Point(x4, y4))) {
                        ans = Math.max(ans, len);
                    }

                    // 반대 방향 90도 회전
                    int x5 = p1.x + dy;
                    int y5 = p1.y - dx;
                    int x6 = p2.x + dy;
                    int y6 = p2.y - dx;

                    if (pointsSet.contains(new Point(x5, y5)) && pointsSet.contains(new Point(x6, y6))) {
                        ans = Math.max(ans, len);
                    }
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
