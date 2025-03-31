#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n;
    string a, b;
    cin >> n >> a >> b;

    // 统计字符串 a 中 0 和 1 的数量
    int x = std::count(a.begin(), a.end(), '0');
    int y = n - x;

    // 统计字符串 b 中 0 和 1 的数量
    int d = std::count(b.begin(), b.end(), '0');
    int e = n - d;

    // 计算最大异或值中 1 的个数
    int ans = min(x, e) + min(d, y);
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
对联【算法赛】
 */