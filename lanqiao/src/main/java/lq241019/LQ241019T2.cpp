#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n, m, k;
    cin >> n >> m >> k;

    vector<int> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
    std::sort(a.begin(), a.end());

    ll s = 0;
    for (int i = 0; i < k; ++i) {
        s += a[i];
    }
    ll ans = (s - 1) / m + 1;
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
黛玉泡茶【算法赛】
 */