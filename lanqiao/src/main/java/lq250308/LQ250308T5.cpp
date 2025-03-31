#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;

    vector<int> a(n), b(n), c(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
    for (int i = 0; i < n; ++i) {
        cin >> b[i];
        c[i] = b[i] - a[i];
    }
    sort(c.begin(), c.end());

    ll ans = 0;
    for (int i = 0; i < n; ++i) {
        int v = a[i] - b[i];
        int cnt = lower_bound(c.begin(), c.end(), v) - c.begin();
        if (v > 0) {
            cnt--;
        }
        ans += cnt;
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
花束搭配【算法赛】
 */