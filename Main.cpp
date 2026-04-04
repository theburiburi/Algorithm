#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M;
vector<vector<int>> list;
vector<int> degree;
priority_queue<int, vector<int>, greater<int>> pq;

void solve(){
    // vector<bool> visited(N+1, false);
    for(int i=1; i<=N; i++){
        if(degree[i] == 0){
            pq.push(i);
        }
    }

    while(!pq.empty()){
        int now = pq.top();
        pq.pop();

        cout << now << " ";
        for(int next : list[now]){
            degree[next]--;

            if(degree[next] == 0){
                pq.push(next);
            }
        }
    }
}

int main(){
    cin.tie(0)->sync_with_stdio(0);

    cin >> N >> M;
    list.resize(N+1);
    degree.resize(N+1, 0);
    for(int i=0; i<M; i++){
        int left, right;
        cin >> left >> right;

        list[left].push_back(right);
        degree[right]++;
    }

    solve();
}