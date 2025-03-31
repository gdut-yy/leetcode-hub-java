#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;

    vector<int> a(n + 1), b(n + 1);
    for (int i = 1; i <= n; ++i) {
        cin >> a[i];
    }
    sort(a.begin(), a.end());

    ll ans = 0;
    for (int i = 1; i <= n; ++i) {
        cin >> b[i];
        int l = i, r = n, p = n + 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (a[mid] > b[i]) {
                p = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        ans += n - p + 1;
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
拳头对决【算法赛】
 */