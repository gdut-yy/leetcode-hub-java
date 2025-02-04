#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

vector<vector<int>> adj;
vector<int> tag;
int ans = 1e9;

// 当前节点，祖先分岔路数量，父亲id
// 返回当前节点的子树是否全部都是
int dfs(int r, int fx, int f) {
    if (adj[r].size() == 1) {
        if (tag[r]) ans = min(ans, fx);
        return tag[r];
    }
    int nfx = adj[r].size() >= 3;
    if (r == 0) nfx = adj[r].size() >= 2;
    int tg = 1;
    for (const auto &tox: adj[r]) {
        if (tox == f) continue;
        tg &= dfs(tox, fx + nfx, r);
    }
    if (tg) ans = min(ans, fx);
    return tg;
}

void solve() {
    int n;
    cin >> n;

    adj = vector<vector<int>>(n);
    tag = vector<int>(n, 0);
    for (int i = 0; i < n - 1; ++i) {
        int l, r;
        cin >> l >> r;
        l--;
        r--;
        adj[l].push_back(r);
        adj[r].push_back(l);
    }
    int m;
    cin >> m;
    for (int i = 0; i < m; ++i) {
        int x;
        cin >> x;
        x--;
        tag[x] = 1;
    }
    dfs(0, 0, -1);
    cout << ans << endl;
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
掩体计划【算法赛】
 */