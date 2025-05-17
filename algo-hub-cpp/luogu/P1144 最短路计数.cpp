#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const int mod = 100003;
int n, m;
vector<vector<int> > g;

void solve() {
    cin >> n >> m;
    g.resize(n);
    for (int i = 0; i < m; ++i) {
        int v, w;
        cin >> v >> w;
        v--;
        w--;
        g[v].emplace_back(w);
        g[w].emplace_back(v);
    }

    vector<ll> f(n);
    vector<ll> dis(n, -1);
    int s = 0;
    dis[s] = 0;
    f[s] = 1;
    queue<int> q;
    q.push(s);
    while (!q.empty()) {
        int v = q.front();
        q.pop();
        ll newD = dis[v] + 1;
        for (const auto &w: g[v]) {
            if (dis[w] < 0) {
                dis[w] = newD;
                f[w] = f[v];
                q.push(w);
            } else if (newD == dis[w]) {
                f[w] = (f[w] + f[v]) % mod;
            }
        }
    }
    for (int i = 0; i < n; ++i) {
        cout << f[i] << endl;
    }
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
    //    cin >> t;
    while (t--) solve();
    return 0;
}

/*
https://www.luogu.com.cn/problem/P1144
 */
