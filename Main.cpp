
// #include <bits/stdc++.h>
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;
string S, T;
int ans = 0;
void dfs(string now){
    if(now.size() == S.size()){
        if(now == S){
            ans = 1;
        }
        return;
    }

    if(now.back() == 'A'){
        now.pop_back();
        dfs(now);
        now.push_back('A');
    }

    if(now.front() == 'B'){
        reverse(now.begin(), now.end());
        now.pop_back();
        dfs(now);
    }
}

int N, K;
int main(){
    cin.tie(0)->sync_with_stdio(0);

    cin >> S >> T;

    dfs(T);

    cout << ans;
}