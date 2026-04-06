#include <iostream>
#include <algorithm>
#include <deque>
#include <vector>

using namespace std;

int N, M;
vector<vector<pair<int, int>>> list;
int start_num, end_num;

bool bfs(int value){
    vector<bool> visited(N+1, false);
    deque<int> dq;
    dq.push_back(start_num);
    visited[start_num] = true;

    while(!dq.empty()){
        int now = dq.front();
        dq.pop_front();

        for(auto next : list[now]){
            if(next.second < value) continue;
            if(visited[next.first]) continue;
            if(next.first == end_num) return true;

            visited[next.first] = true;
            dq.push_back(next.first);
        }
    }
    return false;
}

int main(){
    cin.tie(0)->sync_with_stdio(0);

    cin >> N >> M;
    list.resize(N+1);

    int max_weight = 0;
    for(int i=0; i<M; i++){
        int A,B,C;
        cin >> A >> B >> C;
        list[A].push_back({B, C});
        list[B].push_back({A, C});
        max_weight = max(max_weight, C);
    }
    cin >> start_num >> end_num;

    int left = 1;
    int right = max_weight;
    int answer = 0;
    while(left <= right){
        int mid = left + (right-left)/2;
        if(bfs(mid)){
            answer = mid;
            left = mid+1;
        }
        else{
            right = mid - 1;
        }
    }

    cout << answer;
}