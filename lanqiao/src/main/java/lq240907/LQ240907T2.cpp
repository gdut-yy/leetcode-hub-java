#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int a, b, c;
    cin >> a >> b >> c;

    vector<int> f(b + 1, 1e9);
    f[a] = 0;
    for (int i = a + 1; i <= b; ++i) {
        if (i % c == 0) continue;
        f[i] = min(f[i - 1], f[i - 2]) + 1;
    }
    cout << f[b] << endl;
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
情报传递1【算法赛】

经典爬楼梯问题
状态定义：定义 f[i] 表示走到点 i 最少需要多少步
状态初始化：f[a] 等于 0，其他无穷大
状态转移：f[i] 可以从 f[i-1] 和 f[i-2]得到，若 i 为 c 的倍数则不转移
f[b] 即为答案。
 */