#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n, d;
    cin >> n >> d;

    set<int> s;
    for (int i = 0; i < n; ++i) {
        int x;
        cin >> x;
        s.insert(x);
    }

    int res = 0;
    set<int> t;
    for (int v: s) {
        if (!t.count(v)) {
            int g = v;
            int ans = 0;
            while (s.count(g) && !t.count(g)) {
                ans++;
                t.insert(g);
                g += d;
            }
            res += (ans + 1) / 2;
        }
    }
    cout << res << endl;
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
训练反应力【算法赛】
 */