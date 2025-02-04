#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int mod = 1e9 + 7;
const int N = 1e5 + 7;

int vis[N];

void solve() {
    int n;
    cin >> n;

    ll ans = 1;
    for (int i = 2; i <= n; ++i) {
        if (!vis[i]) {
            int cnt = 0;
            for (int j = i; j <= n; j *= i) {
                cnt += n / j;
            }
            ans *= cnt + 1;
            ans %= mod;
        }
    }
    cout << ans << endl;
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    for (ll i = 2; i <= 1e5; ++i) {
        if (!vis[i]) {
            for (ll j = i * i; j <= 1e5; j += i) {
                vis[j] = 1;
            }
        }
    }

    int t = 1;
//    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
/*
凑单返现【算法赛】
 */