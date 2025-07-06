#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;

    // 存储每天的燃油消耗
    vector<ll> A(n + 1), B(n + 1);
    // 前缀和数组
    vector<ll> prefix_A(n + 1, 0), prefix_B(n + 1, 0);

    for (int i = 1; i <= n; ++i) {
        cin >> A[i];
    }
    for (int i = 1; i <= n; ++i) {
        cin >> B[i];
    }

    // 读入燃油消耗
    for (int i = 1; i <= n; ++i) {
        // 计算前缀和
        prefix_A[i] = prefix_A[i - 1] + A[i];
        prefix_B[i] = prefix_B[i - 1] + B[i];
    }

    // 初始最小消耗：全程用A或B
    ll min_cost = min(prefix_A[n], prefix_B[n]);

    // 情况1：从A切换到B
    for (int k = 1; k < n; ++k) {
        ll cost = prefix_A[k] + (prefix_B[n] - prefix_B[k]);
        min_cost = min(min_cost, cost);
    }
    // 情况2：从B切换到A
    for (int k = 1; k < n; ++k) {
        ll cost = prefix_B[k] + (prefix_A[n] - prefix_A[k]);
        min_cost = min(min_cost, cost);
    }

    // 输出结果
    cout << min_cost << endl;
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
燃油交换【算法赛】
 */