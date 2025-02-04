#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    ll n, m;
    cin >> n >> m;

    ll ans = 10 * n;
    int L = to_string(n).length();

    for (int i = 1; i < 10; ++i) {
        ll s = n + i * pow(10, L);
        if (s % m == 0 && s < ans) {
            ans = s;
        }
    }

    for (int i = 0; i < 10; ++i) {
        for (int j = 1; j < L; ++j) {
            ll s1 = n / pow(10, j);
            ll s2 = n % (ll) pow(10, j);
            ll s = s1 * pow(10, j + 1) + i * pow(10, j) + s2;
            if (s % m == 0 && s < ans) {
                ans = s;
            }
        }
    }

    cout << ans << endl;
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
/*
代金券【算法赛】
 */