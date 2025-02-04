#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    ll n;
    cin >> n;

    ll ans = n * (n - 1) / 2 + (n - 1) * 2 + n + 1;
    cout << ans << endl;
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
排列高手【算法赛】

提示：将 1 和 2 放到数组的两端即可得到最优排列
考虑一种情况，假设排列中没有数字 1，那么所有的子数组 mex 都会是 1.
当我们把数字 1 放入排列中时，有一部分包含数字 1 的子数组的最小排除数会增加，我们称这部分子数组为“受影响的子数组”。
当我们把数字 1 放在第 i 个位置时，受影响的子数组的数量为 i*(n-i+1)。很明显，当 i 是 1 或 n 时，受影响的子数组数量会最小，为 n。
1、不包含数字 1 的子数组：数量为 n(n-1)/2
2、包含数字 1 但不包含数字 2 的子数组：数量是 n-1，mex=2，贡献为 (n-1)*2
3、包含数字 1 且包含数字 2 的子数组：数量是 1，贡献是 n+1。
 */