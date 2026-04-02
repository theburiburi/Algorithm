#include <iostream>
#include <vector>
#include <deque>

using namespace std;


int N, M;
int ans;
vector<pair<int, int>> tree[1001];

void solve(int left, int right);

int main(){
    cin.tie(0)->sync_with_stdio(0);

    cin >> N >> M;
    for(int i=1; i<N; i++){
        int u, v, w;
        cin >> u >> v >> w;
        tree[u].push_back({v, w});
        tree[v].push_back({u, w});
    }

    for(int i=0; i<M; i++){
        ans = 0;
        int left, right;
        cin >> left >> right;

        solve(left, right);
        cout << ans << "\n";
    }
}

void solve(int left, int right){
    bool visited[1001] = {false};
    visited[left] = true;

    deque<pair<int,int>> dq;
    dq.push_back({left, 0});

    while(!dq.empty()){
        auto now = dq.front();
        dq.pop_front();
        
        for(auto next : tree[now.first]){
            if(visited[next.first]) continue;
            if(next.first == right){
                ans = now.second + next.second;
                return;
            }
            visited[next.first] = true;
            dq.push_back({next.first, now.second+ next.second});
        }
    }
}