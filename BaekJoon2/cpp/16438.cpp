#include <iostream>

using namespace std;

int N;
char arr[8][100];

void dfs(int left, int right, int day, char shape){
    if(day >= 8) return;

    int mid = (left + right + 1) / 2;

    for(int i=left; i<right; i++){
        arr[day][i] = shape;
    }

    dfs(left, mid, day+1, shape == 'A' ? 'A' : 'B');
    dfs(mid, right ,day+1, shape == 'A' ? 'B' : 'A');
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    
    for(int i=0; i<8; i++){
        for(int j=0; j<N; j++){
            arr[i][j] = 'A';
        }
        arr[i][N] = '\0';
    }

    dfs(0, N, 0, 'A');

    for(int i=1; i<8; i++){
        cout << arr[i] << '\n';
    }
}