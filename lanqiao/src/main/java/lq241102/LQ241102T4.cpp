#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }

    std::sort(a.begin(), a.end());
    ll ans = std::accumulate(a.begin(), a.end(), 0LL);

    if (a[n - 1] > (ans + 1) / 2) {
        ll tg = a[n - 1] - (ans - a[n - 1]);
        ans += tg - 1;
    }
    cout << ans << endl;
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
//    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
/*
蓝桥商场【算法赛】
 */