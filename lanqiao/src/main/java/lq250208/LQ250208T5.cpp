#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n, k;
    cin >> n >> k;

    vector<int> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
        a[i] %= k;
    }

    std::sort(a.begin(), a.end());
    int ans = a[n - 1] - a[0];
    for (int i = 0; i < n - 1; ++i) {
        ans = min(ans, a[i] + k - a[i + 1]);
    }
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
扑克较量【算法赛】
 */