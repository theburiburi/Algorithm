#include <iostream>
#include <climits>
#include <algorithm>

using namespace std;
using ll = long long;

int main() {
    ll M, A, B;

    cin >> M;
    cin >> A >> B;

    int minCnt = INT_MAX;
    int maxCnt = INT_MIN;

    for(ll target = A; target <= B; target++){
        ll left = 1;
        ll right = M;
        int count = 0;

        while(left <= right){
            ll mid = left +(right-left)/2;
            count++;

            if(mid == target){
                break;
            } else if(mid < target){
                left = mid+1;
            } else{
                right = mid-1;
            }
        }

        minCnt = min(minCnt, count);
        maxCnt = max(maxCnt, count);
    }
    cout << minCnt << ' ' << maxCnt << '\n';

    return 0;
}