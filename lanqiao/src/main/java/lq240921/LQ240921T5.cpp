#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;

    set<int> s;
    for (int i = 0; i < n; ++i) {
        int x;
        cin >> x;
        s.insert(x);
    }

    if (s.size() == 1 || s.size() == n) {
        cout << s.size() << endl;
    } else {
        cout << n - 1 << endl;
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
水杯考验【算法赛】

如果序列 A 中所有数相同，那么无论我们进行什么操作，数值都不会变得不同，因此答案是 1。
如果所有数都不同，那么我们不需要再进行操作，因为不同的数已经是最大数量，因此答案是 N。
此外，我们可以通过操作使得最多有 N-1 个不同的数。
 */