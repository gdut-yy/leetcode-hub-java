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
    ll a, b, c, n;
    cin >> a >> b >> c >> n;

    ll d = a * b % mod * c % mod;
    ll ans = ksm(d, ksm(2, n, mod - 1), mod);
    cout << ans << endl;
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
春晚魔术【算法赛】

可以归纳出，经过 N 次变换后，乘积 P_N = P_{0}^{2^N}。
因此，我们只需要计算结果初始乘积 P0，然后计算 P0 的 2^N 次方即可。
需要注意的是，2N 可能很大，因此我们需要使用快速幂并搭配欧拉降幂来完成计算。
 */