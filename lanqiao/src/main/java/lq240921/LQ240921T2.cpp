#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int N = 1e6 + 10;

void solve() {
    int n;
    cin >> n;

    vector<int> a(N), b(N);
    for (int i = 0; i < n; ++i) {
        int x;
        char c;
        cin >> x >> c;
        if (c == 'F') {
            a[x]++;
        } else {
            b[x]++;
        }
    }

    int ans = 0;
    for (int i = 1; i < N; ++i) {
        ans += min(a[i], b[i]);
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
全栈项目小组【算法赛】

开两个桶分别记录前后端各个薪资的人数，相同薪资情况下加上人数较少的一方的数量进答案
 */