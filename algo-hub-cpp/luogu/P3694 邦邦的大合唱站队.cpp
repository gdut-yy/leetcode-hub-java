#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n, m;
    cin >> n >> m;
    vector<int> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }

    vector<vector<int> > sum(n + 1, vector<int>(20));
    for (int i = 1; i <= n; i++) {
        int v = a[i - 1];
        sum[i] = sum[i - 1];
        sum[i][v - 1]++;
    }

    int u = 1 << m;
    vector<int> sz(u);
    for (int i = 0; i < m; i++) {
        int v = sum[n][i];
        int highBit = 1 << i;
        for (int mask = 0; mask < highBit; mask++) {
            int s = sz[mask];
            sz[highBit | mask] = s + v;
        }
    }

    vector<int> f(u);
    for (int s = 0; s < u; s++) {
        int fs = f[s];
        // for cus, lb := u-1^s, 0; cus > 0; cus ^= lb {
        for (int cus = u - 1 ^ s, lb = 0; cus > 0; cus ^= lb) {
            lb = cus & -cus;
            int ns = s | lb;
            int p = __builtin_ctz(lb);
            f[ns] = max(f[ns], fs + sum[sz[ns]][p] - sum[sz[s]][p]);
        }
    }

    int ans = n - f[u - 1];
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

 */