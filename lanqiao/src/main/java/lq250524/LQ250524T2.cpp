#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int a, b, c;
    cin >> a >> b >> c;
    cout << max(b - a, c - b) - 1 << endl;
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
守护神开会【算法赛】
 */