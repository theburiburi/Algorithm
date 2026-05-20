#include <string>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, -1, 1};

bool check(const vector<string> & place){
    for(int i=0; i<5; i++){
        for(int j=0; j<5; j++){
            if(place[i][j] == 'P'){
                queue<tuple<int, int, int>> que;
                que.push({i, j, 0});
                
                vector<vector<bool>> visited(5, vector<bool>(5, false));
                visited[i][j] = true;
                
                while(!que.empty()){
                    auto [y, x, dist] = que.front();
                    que.pop();
                    
                    if(dist >= 2) continue;
                    
                    for(int k=0; k<4; k++){
                        int ny = y + dy[k];
                        int nx = x + dx[k];
                        
                        if (ny >= 0 && ny < 5 && nx >= 0 && nx < 5 && !visited[ny][nx]) {
                            if (place[ny][nx] == 'O') {
                                visited[ny][nx] = true;
                                que.push({ny, nx, dist + 1});
                            } 
                            else if (place[ny][nx] == 'P') {
                                return false;
                            }
                        }
                    }
                }
            }
        }
    }
    return true;
}


vector<int> solution(vector<vector<string>> places) {
    vector<int> answer;
    
    for (const auto& place : places) {
        if (check(place)) {
            answer.push_back(1);
        } else {
            answer.push_back(0);
        }
    }
    
    return answer;
}