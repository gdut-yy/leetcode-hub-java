#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n, q;
    cin >> n >> q;

    ll ans = 0;
    vector<int> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
        ans += a[i];
    }
    while (q--) {
        int l, r;
        cin >> l >> r;
        int cnt = (r - l + 1) / 2;
        ans -= cnt;
        if ((r - l + 1) % 2) {
            ans += r;
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
蓝桥速算【算法赛】
 */