//#include <bits/stdc++.h>

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

struct Edge{
    int next;
    int L; //이동 비용?
    int C; //간선 값
};

int main(){
    cin.tie(0)->sync_with_stdio(0);

    int N, M, X;

    cin >> N >> M >> X;

    vector<vector<Edge>> graph(N+1);
    vector<int> cValues(M);

    for(int i=0; i<M; i++){
        int I, J, L, C;
        cin >> I >> J >> L >> C;

        graph[I].push_back({J, L, C});
        graph[J].push_back({I, L, C});
        cValues[i] = C;
    }

    if (N == 1) {
        cout << 0 << '\n';
        return 0;
    }

    sort(cValues.begin(), cValues.end());
    cValues.erase(unique(cValues.begin(), cValues.end()), cValues.end());

    const int INF = 1'000'000'000;
    int ans = INF;

    for(int minC : cValues){
        vector<int> dist(N+1, INF);

        priority_queue<
            pair<int, int>,
            vector<pair<int, int>>,
            greater<pair<int, int>>
        > pq;

        dist[1] = 0;
        pq.push({0, 1});

        while(!pq.empty()){
            int nowDist = pq.top().first;
            int now = pq.top().second;
            pq.pop();

            if(nowDist != dist[now]) continue;

            if(now == N) break;

            for(const Edge& edge : graph[now]){
                if (edge.C < minC) continue;

                int next = edge.next;
                int nextDist = nowDist + edge.L;

                if(nextDist < dist[next]){
                    dist[next] = nextDist;
                    pq.push({nextDist, next});
                }
            }
        }

        if(dist[N] != INF){
            int totalTime = dist[N] + X / minC;
            ans = min(ans, totalTime);
        }
    }


    if(ans == INF) {
        cout << -1 << '\n';
    } else {
        cout << ans << '\n';
    }

    return 0;
}