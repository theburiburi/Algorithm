#include <iostream>
#include <deque>

using namespace std;

deque<int> dq;
int N;
long long answer;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    for(int i=0; i<N; i++){
        int now;
        cin >> now;
        while(!dq.empty() && dq.back() <= now){
            dq.pop_back();
        }
        answer += dq.size();

        dq.push_back(now);
    }

    cout << answer;

    return 0;
}