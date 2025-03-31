#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n, x;
    cin >> n >> x;

    while (n--) {
        int l, w;
        cin >> l >> w;

        int ans = l * w;
        while (ans % 2 == 0 && ans > x) {
            ans /= 2;
        }
        cout << (ans == x ? "Yes" : "No") << endl;
    }
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
打花结【算法赛】
 */