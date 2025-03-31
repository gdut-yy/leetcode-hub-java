#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const int N = 1e5 + 10;

void solve() {
    int n;
    cin >> n;

    int x = 0;
    vector<int> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
        x |= a[i];
    }
    for (int i = 0; i < 35; ++i) {
        if ((x >> i & 1) == 0) {
            cout << (1 << i) << endl;
            return;
        }
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
妇女唇膏【算法赛】
 */