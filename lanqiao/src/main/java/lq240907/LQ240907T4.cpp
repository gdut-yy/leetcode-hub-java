#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int dist(int x, int y) {
    return (y - x) / 2 + (y - x) % 2;
}

void solve() {
    int a, b, c;
    cin >> a >> b >> c;

    int d = (a / c + 1) * c;
    int e = (b / c) * c;
    if (d > b) {
        cout << dist(a, b) << endl;
        return;
    }
    int ans = dist(a, d - 1) + dist(e + 1, b) + dist(1, c + 1) * ((e - d) / c) + 1;
    cout << ans << endl;
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
情报传递2【算法赛】

在区间 [a,b] 内存在若干个点为点 c 的倍数，我们设其数量为 x。
1、若 x 为 0，则考虑用最少的步数从 a 到 b，从贪心的角度考虑能走 2 步尽量走 2，即步数为 ceil((b-a)/2)
2、若 x 不为 0。我们设 [a,b] 区间内 c 的倍数，最小的点为 d，最大的点为 e。
 因为不能到达点 d，我们的操作一定是先到达点 d-1，再使用一次加 2 操作跨过 d 到达 d+1。
 同理，我们最后也一定从点 e-1 使用操作 2 到达 e+1。即我们最后可以将 [a,b] 拆为 3 个区间分别计算，即 [a,d-1], [d,e], [e+1,b]。
 其中 [a,d-1] 和 [e+1,b] 比较好计算，因为其中不存在 c 的倍数，所以直接贪心操作即可。
> 重点在于区间 [d,e] 如何计算？
 事实上，[d,e] 就是 x-1 长度为 c 的区间，你只需要计算走一个长度为 c 的区间需要的步数，再乘上 x-1 即可。
 */