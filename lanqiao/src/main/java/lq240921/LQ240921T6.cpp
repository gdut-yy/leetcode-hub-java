#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    ll n;
    cin >> n;

    ll res = n * 45;
    ll ans = 0;
    while (res) {
        ans += res % 10;
        res /= 10;
    }
    cout << ans + 1 << endl;
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
面试官的刁难【算法赛】

答案为 45n 的数位和 +1.
 */