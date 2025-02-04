#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int mod = 1e9 + 7;
const int inv2 = mod - mod / 2;

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
    ll n;
    cin >> n;

    if (n == 4) {
        cout << 18 << endl;
        return;
    }
    ll C = n * (n - 1) % mod * inv2 % mod;
    ll m = (ksm(3, n - 2) - ksm(2, n - 2) + mod) % mod * 2 % mod;
    ll res = (ksm(2, 2 * n - 4) - m + mod) % mod * C % mod;
    cout << res << endl;
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
    cin >> t;
    while (t--) solve();
    return 0;
}
/*
SSP OFFER【算法赛】

涂色方案的总数为 C_{n}^{2} (2^{2n-4} -2(3^{n-2}-2^{n-2}))
 */