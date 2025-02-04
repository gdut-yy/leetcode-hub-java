#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;

    vector<int> a(n), b(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
    for (int i = 0; i < n; ++i) {
        cin >> b[i];
    }
    std::sort(a.begin(), a.end());
    std::sort(b.rbegin(), b.rend());

    int ans = INT_MAX;
    for (int i = 0; i < n; ++i) {
        ans = min(ans, a[i] + b[i]);
    }
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
你会二分吗？【算法赛】

诈骗题。
事实上不需要进行二分，将男员工的 e 人值升序排序，女员工的 e 人值降序排序，下标相同即分为一组，取所有组最小的 e 人值即为答案。
 */