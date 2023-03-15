#include <bits/stdc++.h>

#define ll long long

using namespace std;

struct rec {
    int l, r, x;
};

void solve() {
    int n, K;
    cin >> n >> K;
    vector<ll> a(n + 1), s(n + 1), f(n + 1), g(n + 1);
    vector<rec> q(n + 1);
    for (int i = 1; i <= n; i++) {
        cin >> a[i];
        s[i] = s[i - 1] + a[i];
    }
    // 手写队列的队头和队尾
    int l, r;

    //计算 val 函数
    auto cal = [&](int l, int r) {
        return f[l] + (s[r] - s[l]) * (r - l);
    };

    // 将 i 插入决策队列
    auto insert = [&](int i) {
        int nl = -1;
        // 队尾区间出队
        while (l <= r && cal(i, q[r].l) <= cal(q[r].x, q[r].l)) nl = q[r--].l;
        // 特殊情况，需要二分
        if (l <= r && cal(i, q[r].r) < cal(q[r].x, q[r].r)) {
            int L = q[r].l, R = q[r].r;
            while (L < R) {
                int M = (L + R) / 2;
                if (cal(i, M) <= cal(q[r].x, M)) R = M;
                else L = M + 1;
            }
            q[r].r = L - 1;
            nl = L;
        }
        if (nl != -1) q[++r] = {nl, n, i};
    };

    for (int i = 1; i <= n; i++) {
        f[i] = cal(0, i);
    }
    for (int k = 2; k <= K; k++) {
        l = 0, r = 0;
        q[0] = {1, n, 0};
        for (int i = 1; i <= n; i++) {
            while (l <= r && q[l].r < i) l++;
            q[l].l = i;
            g[i] = cal(q[l].x, i);
            insert(i);
        }
        f = g;
    }

    cout << f[n] << "\n";
}

int main() {
    solve();
}