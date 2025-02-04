#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

template<class Info, class Tag>
struct LazySegmentTree {
    const int n;
    vector<Info> info;
    vector<Tag> tag;

    LazySegmentTree(int n) : n(n), info(4 << (int) log2(n)), tag(4 << (int) log2(n)) {}

    LazySegmentTree(vector<Info> init) : LazySegmentTree(init.size()) {
        function<void(int, int, int)> build = [&](int p, int l, int r) {
            if (r - l == 1) {
                info[p] = init[l];
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

    void apply(int p, const Tag &v) {
        info[p].apply(v);
        tag[p].apply(v);
    }

    void push(int p) {
        apply(2 * p, tag[p]);
        apply(2 * p + 1, tag[p]);
        tag[p] = Tag();
    }

    void modify(int p, int l, int r, int x, const Info &v) {
        if (r - l == 1) {
            info[p] = v;
            return;
        }
        push(p);
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
        push(p);
        return rangeQuery(2 * p, l, m, x, y) +
               rangeQuery(2 * p + 1, m, r, x, y);
    }

    // 查询区间 [l,r)
    Info rangeQuery(int l, int r) {
        return rangeQuery(1, 0, n, l, r);
    }

    void rangeApply(int p, int l, int r, int x, int y, const Tag &v) {
        if (l >= y || r <= x) {
            return;
        }
        if (l >= x && r <= y) {
            apply(p, v);
            return;
        }
        int m = (l + r) / 2;
        push(p);
        rangeApply(2 * p, l, m, x, y, v);
        rangeApply(2 * p + 1, m, r, x, y, v);
        pull(p);
    }

    void rangeApply(int l, int r, const Tag &v) {
        rangeApply(1, 0, n, l, r, v);
    }
};

struct Tag {
    ll add;

    Tag(int _rev = 0) : add{_rev} {}

    void apply(const Tag &t) {
        add += t.add;
    }
};

struct Info {
    int mx = 0;

    void apply(const Tag &t) {
        mx += t.add;
    }
};

Info operator+(Info a, Info b) {
    Info c;
    c.mx = max(a.mx, b.mx);
    return c;
}

void solve() {
    int n;
    cin >> n;

    const int N = 2e5;
    vector<vector<int>> pos(N);
    vector<int> a(n), cnt(N);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
        a[i]--;
        pos[a[i]].push_back(i);
    }

    int ans = 0;
    vector<Info> init(n);
    LazySegmentTree<Info, Tag> seg(init);
    for (int i = 0; i < n; ++i) {
        cnt[a[i]]++;
        if (cnt[a[i]] < pos[a[i]].size()) {
            if (cnt[a[i]] == 1) {
                seg.rangeApply(pos[a[i]][1], pos[a[i]].back(), 1);
            } else {
                seg.rangeApply(pos[a[i]][cnt[a[i]] - 1] + 1, pos[a[i]][cnt[a[i]]], -1);
            }
        }
        ans = max(ans, seg.rangeQuery(i + 1, n).mx);
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
倒斗【算法赛】
 */