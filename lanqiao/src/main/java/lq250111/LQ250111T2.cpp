#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n, m;
    cin >> n >> m;

    vector<int> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }

    std::sort(a.begin(), a.end());
    int ans = INT_MAX;
    for (int i = m - 1; i < n; ++i) {
        ans = min(ans, a[i] - a[i - m + 1]);
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
酒店安排【算法赛】
 */