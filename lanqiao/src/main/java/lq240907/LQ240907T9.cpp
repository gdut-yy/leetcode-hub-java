#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const int N = 3e5 + 10;
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

ll fac[N], inv[N];

void init() {
    int up = N - 10;
    fac[0] = 1;
    for (int i = 1; i <= up; ++i) fac[i] = fac[i - 1] * i % mod;
    inv[up] = ksm(fac[up], mod - 2);
    for (int i = up - 1; i >= 0; --i) inv[i] = inv[i + 1] * (i + 1) % mod;
}

ll C(int n, int m) {
    if (n < m) return 0;
    return fac[n] * inv[m] % mod * inv[n - m] % mod;
}

ll catalan(int n, int k) {
    n--, k--;
    return fac[n + k] * (n - k + 1) % mod * inv[k] % mod * inv[n + 1] % mod;
}

void solve() {
    int n;
    cin >> n;
    ll ans = 0;
    for (int i = 1; i <= n; ++i) {
        int x = 0, k = n - i + 1;
        cin >> x;
        ans += x * catalan(n, k);
        ans %= mod;
    }
    cout << ans << endl;
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    init();
    int t = 1;
//    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
/*
酒量争霸赛【算法赛】
 */