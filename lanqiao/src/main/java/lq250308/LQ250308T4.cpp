#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    ll n, k;
    cin >> n >> k;

    vector<ll> a(n + 1);
    for (int i = 1; i <= n; ++i) {
        cin >> a[i];
    }
    if (k == 1) {
        cout << 0 << endl;
        return;
    }
    sort(a.begin() + 1, a.end());

    vector<ll> s(n + 1);
    for (int i = 1; i <= n; ++i) {
        s[i] = s[i - 1] + a[i];
    }

    ll sum = 0;
    for (int i = 2; i <= k; ++i) {
        sum += a[i] * (i - 1) - s[i - 1];
    }

    ll ans = sum;
    for (int i = 2; i + k - 1 <= n; ++i) {
        ll v = s[i + k - 2] - s[i - 1];
        sum -= v - a[i - 1] * (k - 1);
        sum += a[i + k - 1] * (k - 1) - v;
        ans = min(ans, sum);
    }
    cout << ans << endl;
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
    // cin >> t;
    while (t--) solve();
    return 0;
}
/*
表演队【算法赛】
 */