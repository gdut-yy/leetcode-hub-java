#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n, m;
    cin >> n >> m;

    vector<int> l(n), r(n);
    for (int i = 0; i < n; ++i) {
        cin >> l[i] >> r[i];
    }

    auto st = l, ed = r;
    std::sort(st.begin(), st.end());
    std::sort(ed.begin(), ed.end());

    for (int i = 0; i < n; ++i) {
        int x = n - (std::upper_bound(st.begin(), st.end(), r[i]) - st.begin());
        int y = std::lower_bound(ed.begin(), ed.end(), l[i]) - ed.begin();
        cout << (n - 1 - x - y) << endl;
    }
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
蓝桥派对【算法赛】
 */