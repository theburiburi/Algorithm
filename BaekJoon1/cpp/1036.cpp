#include <iostream>
using namespace std;


int N, K;


struct cmp{
    int get_z_count(const string &s) const{
        int count = 0;
        for(char c : s){
            if(c == 'Z') count++;
            else break;
        }
        return count;
    }
    bool operator () (const string &a, string &b) const{
        int a_score = a.length() - get_z_count(a);
        int b_score = b.length() - get_z_count(b);

        if(a_score == b_score){
            return a > b;
        }
        return a_score < b_score;
    }
};



priority_queue<string, vector<string>, cmp> pq;

int main(){
    cin.tie(0)->sync_with_stdio(0);

    cin >> N;
    for(int i=0; i<N; i++){
        string now;
        cin >> now;
        pq.push(now);
    }
    cin >> K;

    for(int i=0; i<K; i++){
        string now = pq.top();
        pq.pop();

        for(int j=0; j<now.length(); j++){
            if(now[j] != 'Z'){
                now[j] = 'Z';
                break;
            }
        }
        pq.push(now);
    }

    for(int i=0; i<K; i++){
        int 
    }
}