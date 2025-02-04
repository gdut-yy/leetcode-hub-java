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

    int mx = 0;
    vector<int> vis(n + 1);
    for (int i = 0; i < n; ++i) {
        if (mx > a[i]) vis[a[i]] = 1;
        mx = max(mx, a[i]);
    }

    mx = 0;
    for (int i = n - 1; i >= 0; --i) {
        if (mx > a[i]) vis[a[i]] = 1;
        if(vis[a[i]]) mx = max(mx, a[i]);
    }

    int ans = 0;
    for (int i = 1; i <= n; ++i) {
        ans += vis[i];
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
混乱的草稿纸【算法赛】
 */