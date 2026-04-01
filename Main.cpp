#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Node{
    public:
        int num;
        int value; 
};
const int INF = 1e9;

int V, E;
int start;
int ans[20001];
priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int, int>>> pq;
vector<vector<Node>> adj;


void solve(){
    for(int i=1; i<=V; i++){
        ans[i] = INF;
    }

    pq.push({0, start}); //비교하는 걸 먼저 넣어야하나
    ans[start] = 0;
    while(!pq.empty()){
        int dist = pq.top().first;
        int num = pq.top().second;
        pq.pop();

        for(Node next : adj[num]){
            int next_num = next.num;
            int next_value = next.value + dist;

            if(ans[next_num] <= next_value) continue;
            
            ans[next_num] = next_value;
            pq.push({next_value, next_num});
        }
    }

    for(int i=1; i<=V; i++){
        cout << (ans[i] == INF ? "INF" : to_string(ans[i])) << "\n";
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> V >> E;
    cin >> start;

    adj.resize(V+1);

    for(int i=0; i<E; i++){
        int u, v, w;

        cin >> u >> v >> w;
        adj[u].push_back({v,w});
    }

    solve();
}
