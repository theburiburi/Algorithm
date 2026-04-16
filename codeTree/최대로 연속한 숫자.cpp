#include <iostream>
#include <set>

using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);

    int N, M;
    cin >> N >> M;

    set<int> boundaries;
    multiset<int> lengths;

    boundaries.insert(-1);
    boundaries.insert(N + 1);
    lengths.insert(N + 1);

    for(int i=0; i<M; i++){
        int cut;
        cin >> cut;

        auto it = boundaries.upper_bound(cut);
        int right = *it;
        int left = *prev(it);

        int currentLen = right - left - 1;
        lengths.erase(lengths.find(currentLen));

        int leftLen = cut - left - 1;
        int rightLen = right - cut - 1;

        if (leftLen > 0) lengths.insert(leftLen);
        if (rightLen > 0) lengths.insert(rightLen);

        boundaries.insert(cut);

        if (lengths.empty()) {
            cout << 0 << "\n";
        } else {
            cout << *lengths.rbegin() << "\n";
        }
    }

    return 0;
}