#include<bits/stdc++.h>
using namespace std;
#define dbg(x...) do { cout << "\033[32;1m" << #x <<" -> "; err(x); } while (0)
void err() { cout << "\033[39;0m" << endl; }
template<class T, class... Ts> void err(const T& arg,const Ts&... args) { cout << arg << " "; err(args...); }
#define fi first
#define se second
#define pb push_back
#define rep(i,j,k) for (int i = int(j); i <= int(k); i++)
#define per(i,j,k) for(int i=int(j);i>=int(k);i--)
#define all(V) V.begin(), V.end()
typedef unsigned long long ull;
typedef long long ll;
typedef pair<int,int> PII;
typedef pair<long long, long long> PLL;

static constexpr int dist[13][12] = {
  {2, 2, 2, 3, 2, 2, 2, 3, 3, 5, 3, 3},
  {2, 2, 2, 2, 3, 2, 3, 2, 3, 3, 5, 3},
  {2, 2, 2, 2, 2, 3, 3, 3, 2, 3, 3, 5},
  {3, 2, 2, 2, 3, 3, 5, 2, 2, 2, 3, 3},
  {2, 3, 2, 3, 2, 3, 2, 5, 2, 3, 2, 3},
  {2, 2, 3, 3, 3, 2, 2, 2, 5, 3, 3, 2},
  {2, 3, 3, 5, 2, 2, 2, 3, 3, 3, 2, 2},
  {3, 2, 3, 2, 5, 2, 3, 2, 3, 2, 3, 2},
  {3, 3, 2, 2, 2, 5, 3, 3, 2, 2, 2, 3},
  {5, 3, 3, 2, 3, 3, 3, 2, 2, 2, 2, 2},
  {3, 5, 3, 3, 2, 3, 2, 3, 2, 2, 2, 2},
  {3, 3, 5, 3, 3, 2, 2, 2, 3, 2, 2, 2},
  {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}
};
ll d[1005][13][3][13][3][13];
void solve() {
  int D; cin >> D;
  vector<vector<int>> C(12, vector<int>(8, 0));
  for(int i = 0; i < 12; i++){
    for(int j = 1; j <= 7; j++){
      cin >> C[i][j];
    }
  }
  ll rs = 0;
  memset(d, 0xcf, sizeof d);
  d[0][12][0][12][0][12] = 0;
  for(int t = 0; t < D; t++){
    for(int i = 0; i <= 12; i ++) {
      for(int j = 0; j < 3; j++){
        for(int k = 0; k <= 12; k++) {
          if(i == 12 && k != 12) continue;
          for(int l = 0; l < 3; l++){
            for(int o = 0; o <= 12; o++){
              if(k == 12 && o != 12) continue;
              if(d[t][i][j][k][l][o] < 0) continue;
              for(int p = 0; p < 12; p ++){
                int dis = dist[i][p];
                for(int g = 0; g < 3 && t + g + dis <= D; g ++){
                  ll val = d[t][i][j][k][l][o];
                  if(p == i) val += C[p][min(7, dist[i][p] + g)];
                  else if(p == k) val += C[p][min(7, dist[i][p] + g + dist[i][k] + j)];
                  else if(p == o) val += C[p][min(7, dist[i][p] + g + dist[i][k] + j + dist[k][o])];
                  else val += C[p][7];
                  d[t + g + dis][p][g][i][j][k] = max(d[t + g + dis][p][g][i][j][k], val);
                  rs = max(rs, val);
                }
              }
            }
          }
        }
      }
    }
  }
  cout << rs << "\n";
}

int main(){
  ios::sync_with_stdio(false); cin.tie(nullptr);
  int T; T = 1;
  while(T--) {
    solve();
  }
}