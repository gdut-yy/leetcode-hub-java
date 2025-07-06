#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;

    ll odd = 0, even = 0;
    vector<int> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
        if (a[i] % 2) {
            odd++;
        } else {
            even++;
        }
    }

    ll sum = accumulate(a.begin(), a.end(), 0LL);
    if (sum % 2) {
        cout << 0 << endl;
    } else {
        ll ans = even * (even - 1) / 2 + odd * (odd - 1) / 2 + even * odd;
        cout << ans << endl;
    }
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
星座骑士【算法赛】
 */