#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);

    int n;
    cin >> n;

    vector<vector<int>> grid(n, vector<int>(n));

    for (int row = 0; row < n; row++) {
        for (int col = 0; col < n; col++) {
            cin >> grid[row][col];
        }
    }
    long long answer = LLONG_MIN;

    for(int top=0; top<n; top++){
        vector<long long> colSum(n, 0);
        for(int bottom=top; bottom<n; bottom++){

            for(int col=0; col<n; col++){
                colSum[col] += grid[bottom][col];
            }

            long long current = colSum[0];
            long long best = colSum[0];

            for(int col=1; col < n; col++){
                current = max(colSum[col], current+colSum[col]);
                best = max(best, current);
            }
            answer = max(answer, best);
        }
    }


    cout << answer << '\n';
    return 0;
}
