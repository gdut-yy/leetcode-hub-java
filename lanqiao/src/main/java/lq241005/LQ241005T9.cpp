#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int mod = 998244353;
const int inv2 = mod - mod / 2; // 499122177

ll n;

ll solve2() {
    ll min_b = (4 * n + 2) / 3 + ((4 * n + 2) % 3 != 0);
    ll max_b = 2 * n;
    ll cnt_b = max_b - min_b + 1;
    ll x = 3 * min_b - 4 * n - 1;
    ll max_x = 2 * n - 1;
    if (cnt_b == 1) {
        return x;
    }
    return (x + max_x) % mod * cnt_b % mod * inv2 % mod;
}

ll solve3() {
    if (n == 1) return 0ll;
    return n * (n - 1) % mod * 2 % mod * inv2 % mod;
}

void solve() {
    cin >> n;

    int ans = (solve2() + solve3()) % mod;
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
没时间了！【算法赛】

分三种情况讨论：
1、恰好包含一个不超过 2n 的项
    0
2、恰好包含两个不超过 2n 的项
    当 x = 1, 1
    当 x > 1, \frac{[x+(x+3 \times (2n-\lceil \frac{4n+2}{3} \rceil -1))] \times (2n-\lceil \frac{4n+2}{3}\rceil )}{2}
3、恰好包含三个不超过 2n 的项
    2 C_{n}^{2}
 */