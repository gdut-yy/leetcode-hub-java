#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    string s;
    cin >> s;

    int x = 0, y = 0;
    for (const auto &b: s) {
        if (b == 'U') y++;
        if (b == 'D') y--;
        if (b == 'L') x++;
        if (b == 'R') x--;
    }
    if (s.size() % 2 == 1) {
        cout << -1 << endl;
    } else {
        int ans = min(abs(x), abs(y));
        ans += abs(abs(x) - abs(y)) / 2;
        cout << ans << endl;
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
电子舞龙【算法赛】

相似题目: 3443. K 次修改后的最大曼哈顿距离
https://leetcode.cn/problems/maximum-manhattan-distance-after-k-changes/description/
 */