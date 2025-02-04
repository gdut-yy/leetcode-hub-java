#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

template<class Info>
struct SegmentTree {
    int n;
    vector<Info> info;

    SegmentTree() : n(0) {}

    SegmentTree(int n_, Info v_ = Info()) {
        init(n_, v_);
    }

    template<class T>
    SegmentTree(vector<T> init_) {
        init(init_);
    }

    void init(int n_, Info v_ = Info()) {
        init(vector<Info>(n_, v_));
    }

    template<class T>
    void init(vector<T> init_) {
        n = init_.size();
        info.assign(4 << (int) log2(n), Info());
        function<void(int, int, int)> build = [&](int p, int l, int r) {
            if (r - l == 1) {
                info[p] = init_[l];
                return;
            }
            int m = (l + r) / 2;
            build(2 * p, l, m);
            build(2 * p + 1, m, r);
            pull(p);
        };
        build(1, 0, n);
    }

    void pull(int p) {
        info[p] = info[p * 2] + info[p * 2 + 1];
    }

    void modify(int p, int l, int r, int x, const Info &v) {
        if (r - l == 1) {
            info[p] = v;
            return;
        }
        int m = (l + r) / 2;
        if (x < m) {
            modify(2 * p, l, m, x, v);
        } else {
            modify(2 * p + 1, m, r, x, v);
        }
        pull(p);
    }

    // 修改下标为 p 的值的为 v
    void modify(int p, const Info &v) {
        modify(1, 0, n, p, v);
    }

    Info rangeQuery(int p, int l, int r, int x, int y) {
        if (l >= y || r <= x) {
            return Info();
        }
        if (l >= x && r <= y) {
            return info[p];
        }
        int m = (l + r) / 2;
        return rangeQuery(2 * p, l, m, x, y) +
               rangeQuery(2 * p + 1, m, r, x, y);
    }

    // 查询区间 [l,r)
    Info rangeQuery(int l, int r) {
        return rangeQuery(1, 0, n, l, r);
    }

    template<class F>
    int findFirst(int p, int l, int r, int x, int y, F pred) {
        if (l >= y || r <= x || !pred(info[p])) {
            return -1;
        }
        if (r - l == 1) {
            return l;
        }
        int m = (l + r) / 2;
        int res = findFirst(2 * p, l, m, x, y, pred);
        if (res == -1) {
            res = findFirst(2 * p + 1, m, r, x, y, pred);
        }
        return res;
    }

    // 从区间 [l,r) 找到第一个符合条件 pred 的下标，没找到返回 -1
    template<class F>
    int findFirst(int l, int r, F pred) {
        return findFirst(1, 0, n, l, r, pred);
    }

    template<class F>
    int findLast(int p, int l, int r, int x, int y, F pred) {
        if (l >= y || r <= x || !pred(info[p])) {
            return -1;
        }
        if (r - l == 1) {
            return l;
        }
        int m = (l + r) / 2;
        int res = findLast(2 * p + 1, m, r, x, y, pred);
        if (res == -1) {
            res = findLast(2 * p, l, m, x, y, pred);
        }
        return res;
    }

    // 从区间 [l,r) 找到最后一个符合条件 pred 的下标，没找到返回 -1
    template<class F>
    int findLast(int l, int r, F pred) {
        return findLast(1, 0, n, l, r, pred);
    }
};

const ll inf = 1e18;

// 维护区间总和，最大值，最小值
// 注意空集合影响答案的情况
struct Info {
    ll mi = inf;
    ll mx = -inf;
    ll sum = 0;

    Info() {}

    // 用于初始化线段树的构造函数
    Info(ll value) : mx(value), mi(value), sum(value) {}
};

Info operator+(Info a, Info b) {
    Info c;
    c.mx = max(a.mx, b.mx);
    c.mi = min(a.mi, b.mi);
    c.sum = a.sum + b.sum;
    return c;
}

void solve() {
    int n, m;
    cin >> n >> m;

    vector<int> s(n + 1);
    for (int i = 1; i <= n; ++i) {
        cin >> s[i];
    }

    vector<vector<int>> vec(n + 1);
    vector<int> a(m + 1), b(m + 1), p(m + 1);
    for (int i = 1; i <= m; ++i) {
        cin >> a[i] >> b[i] >> p[i];
        vec[b[i]].push_back(i);
    }

    vector<Info> init(n + 1, 0);
    SegmentTree<Info> seg(init);

    vector<ll> f(n + 1);
    for (int i = 1; i <= n; ++i) {
        f[i] = f[i - 1] + s[i];
        for (const auto &x: vec[i]) {
            f[i] = min(f[i], seg.rangeQuery(a[x] - 1, i).mi + p[x]);
        }
        seg.modify(i, f[i]);
    }

    cout << f[n] << endl;
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
算法工程师【算法赛】
 */