#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;

    vector<int> a(n), cnt(1e6 + 5);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
        cnt[a[i]]++;
    }

    int ans = 0;
    for (int i = 1; i <= 1e6; ++i) {
        for (int j = 1; j <= cnt[i]; ++j) {
            if (cnt[j] >= i) {
                ans++;
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
    while (t--) {
        solve();
    }
    return 0;
}
/*
完美数对【算法赛】
 */