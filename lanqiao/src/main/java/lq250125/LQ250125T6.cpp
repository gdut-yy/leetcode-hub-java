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

int one;
int a[32];
ll dp[32][2][2][32];

ll dfs(int len, int limit, int zero, int cnt) {
    if (!len) return cnt == one;
    if (~dp[len][limit][zero][cnt]) return dp[len][limit][zero][cnt];
    ll res = 0;
    int up = limit ? a[len] : 1;
    for (int i = 0; i <= up; ++i) {
        res += dfs(len - 1, limit && i == up, zero && !i, cnt + i);
        res %= mod;
    }
    return dp[len][limit][zero][cnt] = res;
}

ll f(int x) {
    memset(dp, -1, sizeof(dp));
    int len = 0;
    while (x) {
        a[++len] = x % 2;
        x /= 2;
    }
    return dfs(len, 1, 1, 0);
}

void solve() {
    int n, k;
    cin >> n >> k;

    ll ans = 1;
    for (int i = 1; i < 31; ++i) {
        one = i;

        ans += ksm(n, i) * f(k) % mod;
        ans %= mod;
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
知识考量码【算法赛】
 */