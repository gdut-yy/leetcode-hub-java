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
    int ans = 1;
    for (int i = 0; i <= k; ++i) {
        int x = a[i];
        for (int j = 1; j * j <= x; ++j) {
            if (x % j == 0) {
                vector<int> b = {j, x / j};
                for (int d: b) {
                    int cnt = 0;
                    for (int p = 0; p < n; ++p) {
                        cnt += (a[p] % d == 0);
                    }
                    if (cnt >= n - k) {
                        ans = max(ans, d);
                    }
                }
            }
        }
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
智商检测【算法赛】
 */