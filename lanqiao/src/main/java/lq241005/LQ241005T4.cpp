#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    ll n;
    cin >> n;

    ll ans = 0;
    ll cnt = 1;
    while (n > 0) {
        ans += cnt;
        cnt *= 2;
        n /= 2;
    }
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
敲打骷髅兵【算法赛】

设 n 二进制长度为 L，那么答案为 2^L - 1.
 */