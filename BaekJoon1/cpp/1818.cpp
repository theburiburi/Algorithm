#include <iostream>
#include <vector>
#include <algorithm>

//#include <bits/stdc++.h>

using namespace std;

int N;
int arr[200001];

void solve();

int main(){
    cin.tie(0)->sync_with_stdio(0);

    cin >> N;
    for(int i=0; i<N; i++){
        cin >> arr[i];
    }

    solve();
    
    return 0;
}

void solve(){
    vector<int> lis;
    lis.push_back(arr[0]);

    for(int i=1; i<N; i++){
        if(arr[i] > lis.back()){
            lis.push_back(arr[i]);
        }
        else{
            auto it = lower_bound(lis.begin(), lis.end(), arr[i]);
            *it = arr[i];
        }
    }

    cout << N - lis.size() << "\n";
}