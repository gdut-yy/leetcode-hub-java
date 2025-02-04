#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const int mod = 1e9 + 7;
const int MAXN = 1e5 + 10;
ll dp[MAXN][4];

void init() {
    dp[1][1] = 9;
    for (int i = 2; i <= 1e5; ++i) {
        dp[i][1] = dp[i - 1][1];
        dp[i][2] = (dp[i - 1][1] * 9 + dp[i - 1][2] * 2 % mod) % mod;
        dp[i][3] = (dp[i - 1][2] * 8 + dp[i - 1][3] * 3 % mod) % mod;
    }
}

void solve() {
    int n;
    cin >> n;

    cout << dp[n][3] << endl;
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    init();
    int t = 1;
    cin >> t;
    while (t--) solve();
    return 0;
}
/*
清洁客房【算法赛】

定义状态 dp[i][j] 表示安排前 i 间客房的清洁工作，并且使用了 j 种不同清洁等级的方案数。
边界情况，当只有一间客房时，由于清洁等级不能为 0，因此有 9 种选择（1 到 9）。所以 dp[1][1] = 9
j = 1:
    dp[i][1] = dp[i-1][1]
j = 2:
    第 i 间客房的清洁等级与前 i-1 间客房的两种清洁等级之一相同。这种情况下，前 i-1 间客房使用了两种清洁等级，方案数为 dp[i-1][2]，第 i 间客房有 2 种选择
    第 i 间客房的清洁等级与前 i-1 间客房的清洁等级之都不同。这意味着前 i-1 间客房只使用了一种清洁等级，方案数为 dp[i-1][1]，第 i 间客房有 9 种选择
    综上，dp[i][2] = dp[i-1][1] * 9 + dp[i-1][2] * 2
j = 3:
    第 i 间客房的清洁等级与前 i-1 间客房的三种清洁等级之一相同。方案数为 dp[i-1][1] * 3
    第 i 间客房的清洁等级与前 i-1 间客房的清洁等级之都不同。方案数为 dp[i-1][2] * 8
    综上，dp[i][3] = dp[i-1][1] * 8 + dp[i-1][2] * 3
最终，我们要求的是安排 n 间客房且恰好使用三种清洁等级的方案数，即 dp[n][3].
*/