#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int mod = 1e9 + 7;

ll ksm(ll x, ll k, ll mo = mod) {
    ll ans = 1;
    while (k) {
        if (k & 1) ans = ans * x % mo;
        x = x * x % mo;
        k >>= 1;
    }
    return ans;
}

void solve() {
    int l, r;
    cin >> l >> r;

    ll ans = 0;
    for (int i = l + 1; i <= r; ++i) {
        ans += ksm(i - 1, i - 1) * ksm(i, i) % mod;
        ans %= mod;
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
薅羊毛【算法赛】
 */