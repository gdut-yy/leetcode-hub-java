#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int mod = 1e9 + 7;

void solve() {
    int n, c;
    cin >> n >> c;

    map<int, vector<int> > vec;
    for (int i = 0; i < n; ++i) {
        int v;
        cin >> v;
        vec[v].push_back(i);
    }

    ll ans = 1;
    for (const auto &w: vec) {
        auto p = w.second;
        int m = p.size();
        ll cnt = m + 1; // 不监控或监控一台电脑的方案数
        for (int i = 0; i < m - 1; ++i) {
            int l = i + 1, r = m - 1;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (p[mid] - p[i] <= c) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (p[r] - p[i] <= c) {
                cnt += r - i; // 满足条件的 (i,j) 对数
                cnt %= mod;
            }
        }
        ans *= cnt;
        ans %= mod;
    }
    cout << ans - 1 << endl; // 减去所有国家都不监控的方案
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
    // cin >> t;
    while (t--) solve();
    return 0;
}
/*
未来竞赛【算法赛】
 */