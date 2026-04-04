#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int C,N;
int ans;

vector<int> chicken;
vector<pair<int, int>> cow;
 
void solve();

int main(){
    cin.tie(0)->sync_with_stdio(0);
    cin >> C >> N;

    for(int i=0; i<C; i++){
        int num;
        cin >> num;

        chicken.push_back(num);
    }
    for(int i=0; i<N; i++){
        int start, end;
        cin >> start >> end;

        cow.push_back({start, end});
    }

    //sort(chicken.begin(), chicken.end(), greater<int>());
    //sort(chicekn.begin(), chicken.end(), [](int a, int b)){return a > b;});
    // sort(cow.begin(), cow.end(), [](const pair<int, int> &a, const pair<int,int> &b){
    //     if(a.first == b.first){
    //         return a.second < b.second;
    //     }
    //     return a.first < b.first;
    // });
    sort(chicken.begin(), chicken.end());
    sort(cow.begin(), cow.end());

    solve();
    cout << ans;

    return 0;
}

void solve(){
    priority_queue<int, vector<int>, greater<int>> pq;
    ans = 0;
    int cow_idx = 0;

    for(int i=0; i<C; i++){
        int now_chicken_time = chicken[i];

        while(cow_idx < N && cow[cow_idx].first <= now_chicken_time){
            pq.push(cow[cow_idx].second);
            cow_idx++;
        }

        while(!pq.empty() && pq.top() < now_chicken_time){
            pq.pop();
        }

        if(!pq.empty()){
            ans++;
            pq.pop();
        }
    }
}