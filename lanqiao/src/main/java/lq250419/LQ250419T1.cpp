#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int red = 123;
    int yellow = 456;
    int blue = 789;

    int green = min(yellow, blue);
    int ans = red + yellow + blue - green;
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
发射火箭【算法赛】
 */