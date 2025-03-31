#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n, k;
    cin >> n >> k;

    vector<int> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
    sort(a.begin(), a.begin() + k + 1);
    a[1] += a[0];
    a[0] = 0;
    sort(a.begin(), a.end());

    ll ans = 0;
    for (int i = 0; i < n / 2; ++i) {
        ans += a[i];
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
元宵分配【算法赛】
 */