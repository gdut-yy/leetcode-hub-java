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

const int N = 2e5 + 7;
ll inv2;
ll p[N];

void solve() {
    ll n;
    cin >> n;

    ll ans = (ksm(2, n) - 2 + mod) % mod * inv2 % mod * p[n] % mod * 360 % mod;
    cout << ans << endl;
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    inv2 = ksm(2, mod - 2);
    p[1] = 1;
    for (int i = 1; i <= 2e5; ++i) {
        p[i] = p[i - 1] * 10 + 1;
        p[i] %= mod;
    }

    int t = 1;
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
/*
中奖编号【算法赛】
 */