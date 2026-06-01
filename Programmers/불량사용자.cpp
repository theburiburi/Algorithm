#include <string>
#include <vector>
#include <set>

using namespace std;

set<int> ans;

bool match(const string& user1, const string& user2) {
    if (user1.length() != user2.length()) return false;
    
    for (int i = 0; i < user1.length(); i++) {
        if (user2[i] != '*' && user1[i] != user2[i]) {
            return false;
        }
    }
    return true;
}

void dfs(const vector<string>& user_id, const vector<string>& banned_id, int idx, int visited) {
    if (idx == banned_id.size()) {
        ans.insert(visited);
        return;
    }

    for (int i = 0; i < user_id.size(); i++) {
        if (!(visited & (1 << i))) {
            if (match(user_id[i], banned_id[idx])) {
                dfs(user_id, banned_id, idx + 1, visited | (1 << i));
            }
        }
    }
}

int solution(vector<string> user_id, vector<string> banned_id) {
    ans.clear();
    dfs(user_id, banned_id, 0, 0);
    int answer = ans.size();
    return answer;
}