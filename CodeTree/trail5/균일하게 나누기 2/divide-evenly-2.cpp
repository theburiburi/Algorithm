#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    cin.tie(0)->sync_with_stdio(0);

    int N;
    cin >> N;

    vector<pair<int, int>> points(N);
    vector<int> xv, yv;

    for(int i=0; i<N; i++){
        int x, y;
        cin >> x >> y;

        points[i] = {x, y};
        xv.push_back(x);
        yv.push_back(y);
    }

    sort(xv.begin(), xv.end());
    sort(yv.begin(), yv.end());
    xv.erase(unique(xv.begin(), xv.end()), xv.end());
    yv.erase(unique(yv.begin(), yv.end()), yv.end());

    int xSize = xv.size();
    int ySize = yv.size();

    vector<vector<int>> count(ySize+1, vector<int>(xSize+1, 0));

    for(const auto& [x, y] : points){
        int cX = lower_bound(xv.begin(), xv.end(), x) - xv.begin() + 1;
        int cY = lower_bound(yv.begin(), yv.end(), y) - yv.begin() + 1;

        count[cY][cX]++;
    }

    vector<vector<int>> prefix(ySize+1, vector(xSize+1, 0));

    for(int y=1; y<=ySize; y++){
        for(int x=1; x<=xSize; x++){
            prefix[y][x] = count[y][x] + prefix[y-1][x] + prefix[y][x-1] - prefix[y-1][x-1];
        }
    }

    int ans = N;
    for(int y=0; y<ySize; y++){
        for(int x=0; x<xSize; x++){

            int leftBottom = prefix[y][x];

            int leftTop = prefix[ySize][x] - prefix[y][x];

            int rightBottom = prefix[y][xSize] - prefix[y][x];

            int rightTop = N - leftBottom - leftTop - rightBottom;

            int cnt =  max({leftBottom, leftTop, rightBottom, rightTop});

            ans = min(ans, cnt);
        }
    }

    cout << ans <<"\n";
}