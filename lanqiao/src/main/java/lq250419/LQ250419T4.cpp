#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;
    vector<int> a(n - 1);
    for (auto &i: a) {
        cin >> i;
    }

    int res = 0, p = 0;
    while (a[p] != n) {
        res++;
        p = max_element(a.begin() + p, a.begin() + a[p]) - a.begin();
    }
    cout << res + 1 << endl;
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
最佳航线【算法赛】
 */