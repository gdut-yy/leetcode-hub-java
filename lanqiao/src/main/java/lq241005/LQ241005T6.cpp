#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int mod = 998244353;

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
    int n, m;
    cin >> n >> m;

    vector<vector<ll>> f(n + 1, vector<ll>(2));
    f[0][0] = 1;
    for (int i = 1; i <= n; ++i) {
        f[i][0] = (f[i - 1][0] + f[i - 1][1]) * (m - 1);
        f[i][1] = f[i - 1][0];
        f[i][0] %= mod;
    }

    ll ans = f[n][0] + f[n][1] - ksm(m - 1, n);
    ans = (ans % mod + mod) % mod;
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
云顶天宫【算法赛】

假设 dp[n][0] 表示长度为 n 的数组中最后一个元素不是 m 的数组的数量，
dp[n][1] 表示长度为 n 的数组中最后一个元素是 m 的数组的数量，
dp 的初始化是 dp[0][0]=1 和 dp[0][1]=0
    dp[n][0] = (m-1) * (dp[n-1][0] + dp[n-1][1])
因为最后一个元素不是 m，所以可以将其连接到长度为 n-1 的所有有效数组上。
    dp[n][1] = dp[n-1][0]
因为如果将值 m 放在第 n 个元素上，意味着第 n-1 个元素的值不能是 m。
因此，长度为 n 的数组中没有相邻值为 m 的元素的数量是 dp[n][0] + dp[n][1]。然而，数组如果不存在值为 m 的元素。
我们必须减去没有值为 m 的数组的数量，即 (m-1)^n.
 */