import java.util.*;

class UserSolution {
    private int N;
    private int[][] ocean;
    private List<Iceberg> icebergs;

    private final int[] dy = {-1, 0, 1, 0}; // 0:상, 1:우, 2:하, 3:좌
    private final int[] dx = {0, 1, 0, -1};

    private static class Iceberg {
        int dir;
        int vol, area, posY, posX;
        List<int[]> blocks; // {y, x, height}

        Iceberg(int dir) {
            this.dir = dir;
            this.blocks = new ArrayList<>();
        }

        // 이동 전 상태(부피, 면적, 위치) 계산
        void updateStats(int N) {
            vol = 0;
            area = blocks.size();
            posY = N;
            posX = N;
            for (int[] b : blocks) {
                vol += b[2];
                if (b[0] < posY) {
                    posY = b[0];
                    posX = b[1];
                } else if (b[0] == posY) {
                    if (b[1] < posX) posX = b[1];
                }
            }
        }

        // 병합 시 우선순위 비교 (this가 better하면 true)
        boolean isBetterThan(Iceberg other) {
            if (this.vol != other.vol) return this.vol > other.vol;
            if (this.area != other.area) return this.area < other.area;
            if (this.posY != other.posY) return this.posY < other.posY;
            return this.posX < other.posX;
        }
    }

    class RESULT {
        int[][] heights;
        RESULT() {
            heights = new int[100][100];
        }
    }

    void init(int N, int M, int[][] mIceBlock, int[][] mIceGroup) {
        this.N = N;
        this.ocean = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(mIceBlock[i], 0, this.ocean[i], 0, N);
        }

        this.icebergs = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            int seedX = mIceGroup[i][0];
            int seedY = mIceGroup[i][1];
            int dir = mIceGroup[i][2];

            if (!visited[seedY][seedX] && ocean[seedY][seedX] > 0) {
                Iceberg ib = new Iceberg(dir);
                Queue<int[]> q = new ArrayDeque<>();
                q.add(new int[]{seedY, seedX});
                visited[seedY][seedX] = true;

                while (!q.isEmpty()) {
                    int[] curr = q.poll();
                    int y = curr[0], x = curr[1];
                    ib.blocks.add(new int[]{y, x, ocean[y][x]});

                    for (int d = 0; d < 4; d++) {
                        int ny = (y + dy[d] + N) % N;
                        int nx = (x + dx[d] + N) % N;
                        if (!visited[ny][nx] && ocean[ny][nx] > 0) {
                            visited[ny][nx] = true;
                            q.add(new int[]{ny, nx});
                        }
                    }
                }
                icebergs.add(ib);
            }
        }
    }

    RESULT oneYearLater() {
        // 1. 융해 (Melting)
        boolean[][] toMelt = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ocean[i][j] > 0) {
                    for (int d = 0; d < 4; d++) {
                        if (ocean[(i + dy[d] + N) % N][(j + dx[d] + N) % N] == 0) {
                            toMelt[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (toMelt[i][j]) ocean[i][j]--;
            }
        }

        // 2. 분할 (Splitting)
        List<Iceberg> splitIcebergs = new ArrayList<>();
        for (Iceberg ib : icebergs) {
            Set<Integer> surviving = new HashSet<>();
            for (int[] b : ib.blocks) {
                if (ocean[b[0]][b[1]] > 0) surviving.add(b[0] * N + b[1]);
            }
            
            while (!surviving.isEmpty()) {
                int start = surviving.iterator().next();
                surviving.remove(start);
                Iceberg newPart = new Iceberg(ib.dir);
                Queue<Integer> q = new ArrayDeque<>();
                q.add(start);

                while (!q.isEmpty()) {
                    int curr = q.poll();
                    int y = curr / N, x = curr % N;
                    newPart.blocks.add(new int[]{y, x, ocean[y][x]});
                    for (int d = 0; d < 4; d++) {
                        int ny = (y + dy[d] + N) % N;
                        int nx = (x + dx[d] + N) % N;
                        int nextKey = ny * N + nx;
                        if (surviving.contains(nextKey)) {
                            surviving.remove(nextKey);
                            q.add(nextKey);
                        }
                    }
                }
                newPart.updateStats(N);
                splitIcebergs.add(newPart);
            }
        }

        // 3. 이동 및 충돌 (Move & Overlap)
        int[][] nextOcean = new int[N][N];
        // 각 좌표에 도달한 빙하들의 인덱스 목록 (병합 시 방향 결정용)
        List<Integer>[][] cellContributors = new ArrayList[N][N];
        
        for (int i = 0; i < splitIcebergs.size(); i++) {
            Iceberg ib = splitIcebergs.get(i);
            for (int[] b : ib.blocks) {
                int ny = (b[0] + dy[ib.dir] + N) % N;
                int nx = (b[1] + dx[ib.dir] + N) % N;
                if (nextOcean[ny][nx] < b[2]) nextOcean[ny][nx] = b[2];
                if (cellContributors[ny][nx] == null) cellContributors[ny][nx] = new ArrayList<>();
                cellContributors[ny][nx].add(i);
            }
        }
        ocean = nextOcean;

        // 4. 병합 (Merging)
        List<Iceberg> nextIcebergs = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ocean[i][j] > 0 && !visited[i][j]) {
                    List<int[]> componentBlocks = new ArrayList<>();
                    Set<Integer> contributorIds = new HashSet<>();
                    Queue<int[]> q = new ArrayDeque<>();
                    
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int y = curr[0], x = curr[1];
                        componentBlocks.add(new int[]{y, x, ocean[y][x]});
                        if (cellContributors[y][x] != null) {
                            contributorIds.addAll(cellContributors[y][x]);
                        }

                        for (int d = 0; d < 4; d++) {
                            int ny = (y + dy[d] + N) % N;
                            int nx = (x + dx[d] + N) % N;
                            if (ocean[ny][nx] > 0 && !visited[ny][nx]) {
                                visited[ny][nx] = true;
                                q.add(new int[]{ny, nx});
                            }
                        }
                    }

                    // 병합된 빙하의 방향 결정
                    Iceberg winner = null;
                    for (int id : contributorIds) {
                        Iceberg contender = splitIcebergs.get(id);
                        if (winner == null || contender.isBetterThan(winner)) {
                            winner = contender;
                        }
                    }
                    
                    Iceberg merged = new Iceberg(winner.dir);
                    merged.blocks = componentBlocks;
                    nextIcebergs.add(merged);
                }
            }
        }
        this.icebergs = nextIcebergs;

        // 결과 반환
        RESULT res = new RESULT();
        for (int i = 0; i < N; i++) {
            System.arraycopy(ocean[i], 0, res.heights[i], 0, N);
        }
        return res;
    }
}