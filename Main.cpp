#include <iostream>
#include <bitset>
#include <cstring>

using namespace std;

bitset<501> taller[501];
bitset<501> smaller[501];

int main(){
    int T;
    cin >> T;

    for(int t=1; t<=T; t++){
        int N, M;
        cin >> N >> M;

        for(int i=1; i<N; i++){
            taller[i].reset();
            smaller[i].reset();
        }

        for(int i=0; i<M; i++){
            int left, right;
            cin >> left >> right;

            taller[left].set(right);
            smaller[right].set(left);
        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                if(taller[i].test(k)){
                    taller[i] |= smaller[k];
                }
                if(smaller[i].test(k)){
                    smaller[i] |= smaller[k];
                }
            }
        }

        int ans = 0;
        for(int i=1; i<=N; i++){
            if(taller[i].count() + smaller[i].count() == N - 1){
                ans++;
            }
        }
        cout << "#" << t << " " << ans << "\n";
    }
}