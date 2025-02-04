#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n, m, k;
    cin >> n >> m >> k;

    string s, t;
    cin >> s >> t;

    vector<int> a(n), b(m);
    for (int i = 0; i < n; ++i) {
        a[i] = s[i] - '0';
    }
    for (int i = 0; i < m; ++i) {
        b[i] = t[i] - '0';
    }

    ll c = 0;
    ll mx = -1e9, mi = 1e9;
    for (int i = 0; i < n; ++i) {
        c += (a[i] == 0);
        if (i - k >= 0) {
            c -= (a[i - k] == 0);
        }
        if (i >= k - 1) {
            mx = max(mx, c);
            mi = min(mi, c);
        }
    }

    ll tg = 0;
    ll ans = 0;
    for (int i = 0; i < m; ++i) {
        tg += (b[i] == 0);
        if (i - k >= 0) {
            tg -= (b[i - k] == 0);
        }
        if (i >= k - 1) {
            if (2 * tg > k) {
                ans = max(ans, 1LL * k * tg + 1LL * mi * (k - 2 * tg));
            } else {
                ans = max(ans, 1LL * k * tg + 1LL * mx * (k - 2 * tg));
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
宝玉与黛玉的考验【算法赛】
 */