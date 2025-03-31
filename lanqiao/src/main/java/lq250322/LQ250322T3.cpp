#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;

    vector<int> a(n), b(n);
    vector<pair<int, int> > c(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i] >> b[i];
        c[i] = {a[i] - b[i], i};
    }
    sort(c.rbegin(), c.rend());

    ll ans = 0;
    for (int i = 0; i < n; ++i) {
        if (i < n / 2) {
            ans += a[c[i].second];
        } else {
            ans += b[c[i].second];
        }
    }
    cout << ans << endl;
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
蓝桥大使【算法赛】
 */