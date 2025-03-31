#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const int MAX = 1e3 + 7;
int a[MAX][MAX], dp[MAX][MAX];

void solve() {
    int n;
    cin >> n;

    for (int i = 0; i <= n + 1; ++i) {
        for (int j = 0; j <= n + 1; ++j) {
            dp[i][j] = 1e9;
        }
        a[0][i] = a[i][0] = -1;
    }

    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            int x;
            cin >> x;
            if (x & 1) {
                a[i][j] = 1;
            } else {
                a[i][j] = 0;
            }
        }
    }

    dp[1][1] = (a[1][1] ? 0 : n);

    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            dp[i][j] = min(dp[i][j], dp[i - 1][j] + (a[i][j] == 0) * n);
            if (a[i][j] == a[i][j - 1]) {
                dp[i][j] = min(dp[i][j], dp[i][j - 1]);
            }
        }
    }

    if (dp[n][n] == 1e9) {
        cout << "NO!" << endl;
    } else {
        cout << dp[n][n] << endl;
    }
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
舞狮表演【算法赛】
 */