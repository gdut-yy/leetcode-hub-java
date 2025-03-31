#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
    vector<int> b = a;
    std::sort(b.begin(), b.end());

    int cur = 0;
    int ans = 0;
    for (int i = 0; i < n; ++i) {
        if (a[i] != b[cur]) {
            ans++;
        } else {
            cur++;
        }
    }
    cout << ans << endl;
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
喜糖摆放【算法赛】
 */