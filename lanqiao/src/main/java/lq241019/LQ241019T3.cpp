#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int x1, x2, x3;
    cin >> x1 >> x2 >> x3;

    if (x1 <= x2 && x1 <= x3) {
        cout << max(x2, x3) - x1 << endl;
    } else if (x1 >= x2 && x1 >= x3) {
        cout << x1 - min(x2, x3) << endl;
    } else {
        int y1 = abs(x1 - x2);
        int y2 = abs(x1 - x3);
        if (y1 > y2) {
            swap(y1, y2);
        }
        cout << y1 * 2 + y2 << endl;
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
宝玉请安【算法赛】

分类讨论。
 */