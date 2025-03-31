#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n, m;
    cin >> n >> m;

    int x = 1;
    ll ans = 0;
    for (int i = 0; i < n; ++i) {
        int l, r;
        cin >> l >> r;
        if (x < l) {
            ans += l - x;
            x = l;
        } else if (x > r) {
            ans += x - r;
            x = r;
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
灯笼猜谜【算法赛】
 */