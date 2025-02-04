#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n, q;
    cin >> n >> q;

    ll a = 0, b = 0;
    for (int i = 0; i < q; ++i) {
        int t, x, y;
        cin >> t >> x >> y;
        if (t == 1) {
            a += y;
            if (x == n) {
                b += y;
            }
        } else {
            b -= y;
            if (x == n) {
                a -= y;
            }
        }
    }
    cout << max(abs(a), abs(b)) << endl;
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
贾母祝寿【算法赛】

因为我们只关心所有元素的绝对值的最大值，所以我们只需要考虑最终数组的最大值和最小值。
对于每个增量查询，第一个元素会受到影响；而对于每个减量查询，最后一个元素会受到影响。因此第一个元素将成为最大值，最后一个元素将成为最小值。
 */