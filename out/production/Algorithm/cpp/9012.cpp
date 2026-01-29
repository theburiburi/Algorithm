#include <iostream>
#include <stack>
using namespace std;

int main() {
    cin.tie(0);
    cout.tie(0);
    int T;
    cin >> T;
    cin.ignore(); // 입력 버퍼 비우기

    for (int i = 0; i < T; i++) {
        char round[51];
        cin.getline(round, 51); // 공백 포함한 문자열 입력

        stack<char> check;
        bool isValid = true;

        for (int j = 0; round[j] != '\0'; j++) {
            if (round[j] == '(')
                check.push(round[j]);
            else if (round[j] == ')') {
                if (!check.empty() && check.top() == '(')
                    check.pop();
                else {
                    isValid = false;
                    break;
                }
            }
        }

        if (isValid && check.empty())
            cout << "YES\n";
        else
            cout << "NO\n";
    }
    return 0;
}
