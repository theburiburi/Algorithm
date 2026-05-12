#include <vector>
#include <stack>

using namespace std;

int solution(vector<int> order) {
    int answer = 0;
    stack<int> belt;
    int box = 1;
    int idx = 0;

    while (box <= order.size()) {
        belt.push(box);
        
        while (!belt.empty() && belt.top() == order[idx]) {
            belt.pop();
            idx++;
            answer++;
        }
        
        box++;
    }

    return answer;
}