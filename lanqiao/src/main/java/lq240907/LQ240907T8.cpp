#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int MX = 55440; // 1~24 合数乘积
void solve() {
    int n, k;
    cin >> n >> k;

    vector<vector<ll>> dp(k + 1, vector<ll>(55440 + 1));
    dp[0][0] = 1;
    vector<int> A;
    for (int i = 1; i <= n; ++i) {
        if (i != 13 && i != 17 && i != 19 && i != 23) {
            A.push_back(MX / i);
        }
    }
    for (int i = 0; i < k; ++i) {
        for (int j = 0; j <= MX; ++j) {
            for (const auto &k0: A) {
                if (j + k0 <= MX) {
                    dp[i + 1][j + k0] += dp[i][j];
                }
            }
        }
    }
    ll ans = dp[k][MX];
    if (k == 13 || k == 17 || k == 19 || k == 23) {
        ans++;
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
晁盖分饼【算法赛】
 */