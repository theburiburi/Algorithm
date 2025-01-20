public class UserSolution {
    private int[][] map;
    private int N;       
    private int M;       

    public void init(int N, int M, int[][] Map) {
        this.N = N;
        this.M = M;
        this.map = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            System.arraycopy(Map[i], 0, this.map[i], 0, N);
        }
    }

    public Result findTreasureChest(int[][] Pieces) {
        for (int rotation = 0; rotation < 4; rotation++) {
            int[][] rotatedPieces = rotate(Pieces, rotation);

            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    if (matches(rotatedPieces, i, j)) {
                        for (int x = 0; x < M; x++) {
                            for (int y = 0; y < M; y++) {
                                if (rotatedPieces[x][y] == 9) {
                                    return new Result(i + x, j + y);
                                }
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    private int[][] rotate(int[][] pieces, int rotation) {
        int[][] rotated = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (rotation == 0) {
                    rotated[i][j] = pieces[i][j];
                } else if (rotation == 1) {
                    rotated[i][j] = pieces[M - j - 1][i];
                } else if (rotation == 2) { 
                    rotated[i][j] = pieces[M - i - 1][M - j - 1];
                } else if (rotation == 3) {
                    rotated[i][j] = pieces[j][M - i - 1];
                }
            }
        }
        return rotated;
    }

    private boolean matches(int[][] pieces, int startX, int startY) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (pieces[i][j] != 0 && pieces[i][j] != map[startX + i][startY + j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static class Result {
        int x, y;

        public Result(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
