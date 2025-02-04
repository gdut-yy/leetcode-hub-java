#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    ll n, k;
    cin >> n >> k;

    vector<ll> A(20);
    ll m = 1;
    for (int i = 0; i < 20; ++i) {
        A[i] = m;
        m *= (n % 10) + 1;
        n /= 10;
    }
    ll ans = 0;
    k--;
    for (int i = 19; i >= 0; --i) {
        ans *= 10;
        ans += k / A[i];
        k %= A[i];
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
武功秘籍【算法赛】
 */