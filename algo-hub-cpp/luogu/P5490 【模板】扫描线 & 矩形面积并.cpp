#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

template<class Info, class Tag>
struct LazySegmentTree {
    const int n;
    vector<Info> info;
    vector<Tag> tag;

    LazySegmentTree(int n) : n(n), info(4 << (int) log2(n)), tag(4 << (int) log2(n)) {
    }

    LazySegmentTree(vector<Info> init) : LazySegmentTree(init.size()) {
        function<void(int, int, int)> build = [&](int p, int l, int r) {
            if (l == r) {
                info[p] = init[l - 1];
                return;
            }
            int m = (l + r) / 2;
            build(2 * p, l, m);
            build(2 * p + 1, m + 1, r);
            pull(p);
        };
        build(1, 1, n);
    }

    void pull(int p) {
        info[p] = info[p * 2] + info[p * 2 + 1];
    }

    void apply(int p, const Tag &v) {
        info[p].apply(v);
        tag[p].apply(v);
    }

    void push(int p) {
        apply(2 * p, tag[p]);
        apply(2 * p + 1, tag[p]);
        tag[p] = Tag();
    }

    void rangeApply(int p, int l, int r, int ql, int qr, const Tag &v) {
        if (ql <= l && r <= qr) {
            apply(p, v);
            return;
        }
        int m = (l + r) / 2;
        push(p);
        if (ql <= m) rangeApply(2 * p, l, m, ql, qr, v);
        if (qr > m) rangeApply(2 * p + 1, m + 1, r, ql, qr, v);
        pull(p);
    }

    void rangeApply(int l, int r, const Tag &v) {
        rangeApply(1, 1, n, l, r, v);
    }
};

struct Tag {
    ll add;

    Tag(int _rev = 0) : add{_rev} {
    }

    void apply(const Tag &t) {
        add += t.add;
    }
};

struct Info {
    int mn, len;

    Info() : mn(0), len(0) {
    }

    Info(int v, int x) : mn(v), len(x) {
    }

    void apply(const Tag &t) {
        mn += t.add;
    }
};

Info operator+(Info a, Info b) {
    Info c;
    int mn = min(a.mn, b.mn);
    c.mn = mn;
    c.len = (a.mn == mn ? a.len : 0) + (b.mn == mn ? b.len : 0);
    return c;
}

void solve() {
    int n;
    cin >> n;

    vector<array<int, 4> > rectangles(n);
    for (auto &re: rectangles) {
        cin >> re[0] >> re[1] >> re[2] >> re[3];
    }

    int m = 0;
    map<int, int> mp;
    for (const auto &re: rectangles) mp[re[0]] = mp[re[2]] = 1;
    for (auto &p: mp) p.second = m++;
    int A[m];
    for (auto &p: mp) A[p.second] = p.first;

    // 把正方形的上下边界取出来
    vector<array<int, 4> > vec;
    for (auto &re: rectangles) {
        vec.push_back({re[1], mp[re[0]] + 1, mp[re[2]], 1});
        vec.push_back({re[3], mp[re[0]] + 1, mp[re[2]], -1});
    }
    sort(vec.begin(), vec.end());

    vector<Info> init(m - 1);
    for (int i = 1; i < m; ++i) {
        init[i - 1] = Info(0, A[i] - A[i - 1]);
    }
    LazySegmentTree<Info, Tag> seg(init);

    // 求总的面积并
    ll tot = 0;
    for (int i = 0; i + 1 < vec.size(); i++) {
        // 考虑水平线 y = vec[i][0] 和 y = vec[i + 1][0] 之间的情况
        seg.rangeApply(1, 1, m - 1, vec[i][1], vec[i][2], vec[i][3]);
        // 求横截长度
        int len = A[m - 1] - A[0];
        // 如果最小覆盖数是 0，那么扣掉相应的长度
        if (seg.info[1].mn == 0) len -= seg.info[1].len;
        // 面积 = 横截长度 * 高度差
        tot += 1LL * len * (vec[i + 1][0] - vec[i][0]);
    }
    cout << tot << endl;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
    //    cin >> t;
    while (t--) solve();
    return 0;
}

/*
https://www.luogu.com.cn/problem/P5490
 */
