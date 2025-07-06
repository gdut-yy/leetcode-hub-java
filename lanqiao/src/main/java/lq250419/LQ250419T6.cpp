#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const int mod = 1e9 + 7;

void solve() {
    ll a, b, c;
    cin >> a >> b >> c;

    if (a > c) {
        cout << b + c * 2 << endl;
    } else {
        cout << b / 2 * 2 + a * 2 + (c - a) / 2 << endl;
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
吃零食训练【算法赛】
 */