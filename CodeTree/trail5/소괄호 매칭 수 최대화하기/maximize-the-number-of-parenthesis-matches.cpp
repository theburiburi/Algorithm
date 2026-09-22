#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
using ll = long long;

struct Info{
    ll open;
    ll close;

    // bool operator<(const Info& other) const{
    //     return open * other.close > close * other.open;
    // }
    // sort(strings.begin(), strings.end());
};

bool compare(const Info& a, const Info& b){
    return a.open * b.close > a.close * b.open;
}

int main(){
    cin.tie(0)->sync_with_stdio(0);

    int N;
    cin >> N;

    vector<Info> strings;
    strings.reserve(N);
    
    ll answer = 0;

    for(int i=0; i<N; i++){
        string s;
        cin >> s;

        ll open = 0;
        ll close = 0;

        for (char ch : s){
            if( ch == '('){
                open++;
            } else {
                answer += open;
                close++;
            }
        }
        strings.push_back({open, close});
    }


    sort(strings.begin(), strings.end(), compare);

    // sort(strings.begin(), strings.end(), [](const Info&a, const Info&b){
    //     return a.open * b.close > a.close * b.open;
    // });
    
    ll prefixOpen = 0;

    for(const Info& current : strings){
        answer += prefixOpen * current.close;
        prefixOpen += current.open;
    }

    cout << answer << '\n';

    return 0;
}