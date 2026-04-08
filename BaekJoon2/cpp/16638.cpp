#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <climits>

using namespace std;

int N;
long long ans = LLONG_MIN;
string expression;
vector<bool> parenthesis;

long long calculate(long long a, long long b, char op) {
    if (op == '+') return a + b;
    else if (op == '-') return a - b;
    else return a * b;
}

long long solve() {
    vector<long long> nums;
    vector<char> ops;

    for (int i = 0; i < N / 2; i++) {
        if (parenthesis[i]) {
            long long res = calculate(expression[i * 2] - '0', expression[i * 2 + 2] - '0', expression[i * 2 + 1]);
            nums.push_back(res);
            
            if (i + 1 < N / 2) {
                ops.push_back(expression[i * 2 + 3]);
                i++;
            }
        } else {
            nums.push_back(expression[i * 2] - '0');
            ops.push_back(expression[i * 2 + 1]);
        }
    }

    if (nums.size() <= ops.size()) {
        nums.push_back(expression[N - 1] - '0');
    }

    vector<long long> nums2;
    vector<char> ops2;
    if (!nums.empty()) nums2.push_back(nums[0]);

    for (int i = 0; i < (int)ops.size(); i++) {
        if (ops[i] == '*') {
            long long last_num = nums2.back();
            nums2.pop_back();
            nums2.push_back(calculate(last_num, nums[i + 1], '*'));
        } else {
            ops2.push_back(ops[i]);
            nums2.push_back(nums[i + 1]);
        }
    }

    long long final_res = nums2[0];
    for (int i = 0; i < (int)ops2.size(); i++) {
        final_res = calculate(final_res, nums2[i + 1], ops2[i]);
    }

    return final_res;
}

void dfs(int depth) {
    if (depth >= N / 2) {
        ans = max(ans, solve());
        return;
    }

    parenthesis[depth] = true;
    dfs(depth + 2);
    
    parenthesis[depth] = false;
    dfs(depth + 1);
}

int main() {
    cin.tie(0)->sync_with_stdio(0);

    cin >> N >> expression;

    if (N == 1) {
        cout << expression << "\n";
        return 0;
    }

    parenthesis.resize(N / 2, false);
    dfs(0);

    cout << ans << "\n";

    return 0;
}