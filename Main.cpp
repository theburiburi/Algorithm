//#include <bits/stdc++.h>

#include <iostream>
#include <algorithm>

using namespace std;

long long N;
int K;
int main(){
    cin.tie(0)->sync_with_stdio(0);

    cin >> N >> K;
    
    long long low = 1;
    long long high = N*N;
    long long ans = 0;
    while(low <= high){
        long long mid = (low + high)/2;
        long long count = 0;

        for(int i=1; i<=N; i++){
            count += min(N, mid/i);
        }

        if (count >= K){
            ans = mid;
            high = mid-1;
        }
        else{
            low = mid+1;
        }
    }

    cout << ans;
}