#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    ll n, m, k;
    cin >> n >> m >> k;

    ll ans = min(n / 2, m);
    n -= ans * 3;
    k -= n + m;

    k = max(k, 0LL);
    ll need = (k + 2) / 3;
    ans -= need;

    cout << ans << endl;
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
/*
男女搭配【算法赛】
 */