#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N, M;
const int INF = 1e9;

vector<vector<int>> arr;

void floyd(){
    for(int k=1; k<=N; k++){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(arr[i][j] > arr[i][k] + arr[k][j]){
                    arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
    }

    for(int i=1; i<= N; i++){
        for(int j=1; j<=N; j++){
            cout << arr[i][j] << " ";
        }
        cout << "\n";
    }
}

int main(){
    cin.tie(0)->sync_with_stdio(0);

    cin >> N >> M;
    arr.assign(N+1, vector<int>(N+1, INF));
    
    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            if(i==j){
                arr[i][j] = 0;
            }
        }
    }

    for(int i=0; i<M; i++){
        int left, right, value;
        cin >> left >> right >> value;

        arr[left][right] = min(arr[left][right], value);
    }

    floyd();

    return 0;
}