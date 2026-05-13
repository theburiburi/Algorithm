class Solution {
    int yLen, xLen;
    int ans;

    int[] dy = {-1, 0, 1, 0}; 
    int[] dx = {0, 1, 0, -1};
    
    boolean[][] port = { // 상 우 하 좌
        {false, false, false, false},
        {false, true,  false, true},
        {true,  false, true,  false},
        {true,  true,  true,  true}, 
        {true,  false, false, true}, 
        {true,  true,  false, false},
        {false, true,  true,  false},
        {false, false, true,  true}
    };

    public int solution(int[][] grid) {
        yLen = grid.length;
        xLen = grid[0].length;
        ans = 0;
        
        dfs(0, 0, grid);
        
        return ans;
    }

    boolean isValid(int y, int x, int railType, int[][] grid) {
        boolean up = (railType > 0) ? port[railType][0] : false;
        boolean right = (railType > 0) ? port[railType][1] : false;
        boolean down = (railType > 0) ? port[railType][2] : false;
        boolean left = (railType > 0) ? port[railType][3] : false;
        
        if (y > 0) {
            int upRailType = grid[y - 1][x];
            boolean upRailDownPort = (upRailType > 0) ? port[upRailType][2] : false;
            if (up != upRailDownPort) return false;
        } else if (up) return false;
        
        if (x > 0) {
            int leftRailType = grid[y][x - 1];
            boolean leftRailRightPort = (leftRailType > 0) ? port[leftRailType][1] : false;
            if (left != leftRailRightPort) return false;
        } else if (left && !(y == 0 && x == 0)) return false;

        if (x == xLen - 1 && right && !(y == yLen - 1 && x == xLen - 1)) return false;
        if (y == yLen - 1 && down && !(y == yLen - 1 && x == xLen - 1)) return false;
        
        return true;
    }

    boolean check(int[][] grid) {
        int targetCount = 0;
        for (int i = 0; i < yLen; i++) {
            for (int j = 0; j < xLen; j++) {
                if (grid[i][j] > 0) {
                    targetCount += (grid[i][j] == 3) ? 2 : 1;
                }
            }
        }

        int y = 0, x = 0, dir = 1, currentCount = 0;
        
        while (true) {
            if (y < 0 || y >= yLen || x < 0 || x >= xLen) {
                int prevY = y - dy[dir];
                int prevX = x - dx[dir];
                return (prevY == yLen - 1 && prevX == xLen - 1 && currentCount == targetCount);
            }
            
            int currentRailType = grid[y][x];
            if (currentRailType <= 0) return false;
            
            int inPort = (dir + 2) % 4;
            if (!port[currentRailType][inPort]) return false;
            
            if (++currentCount > targetCount) return false;
            
            int outPort = (currentRailType == 3) ? dir : -1;
            if (currentRailType != 3) {
                for (int p = 0; p < 4; p++) {
                    if (port[currentRailType][p] && p != inPort) {
                        outPort = p;
                        break;
                    }
                }
            }
            
            dir = outPort;
            y += dy[dir];
            x += dx[dir];
        }
    }

    void dfs(int y, int x, int[][] grid) {
        if (y == yLen) {
            if (check(grid)) ans++;
            return;
        }
        
        int ny = y + (x + 1) / xLen;
        int nx = (x + 1) % xLen;
        
        if (grid[y][x] != 0) { 
            if (isValid(y, x, grid[y][x], grid)) dfs(ny, nx, grid);
        } else { 
            for (int i = 0; i <= 7; i++) {
                if (isValid(y, x, i, grid)) {
                    grid[y][x] = i;
                    dfs(ny, nx, grid);
                    grid[y][x] = 0;
                }
            }
        }
    }
}