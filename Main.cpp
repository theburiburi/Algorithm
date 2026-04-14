//#include <bits/stdc++.h>

#include <iostream>
#include <algorithm>

using namespace std;

int N, K;
int main(){
    cin.tie(0)->sync_with_stdio(0);

    cin >> N >> K;
    
    int low = 1;
    int high = N*N;
    int ans = 0;
    while(low <= high){
        int mid = (low + high)/2;
        int count = 0;

        for(int i=1; i<=N; i++){
            count += min(N, mid/i);
        }

        if (mid >= K){
            ans = mid;
            high = mid-1;
        }
        else{
            mid = mid+1;
        }
    }

    cout << ans;
}