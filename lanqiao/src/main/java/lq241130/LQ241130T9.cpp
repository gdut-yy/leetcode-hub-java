#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

vector<int> pre;
const int N = 1e5 + 10;

char str[N << 1];
int w, sa[N], rk[N << 1], oldrk[N << 1];
vector<int> height(N * 2, 0);

void getsa(string s) {
//    int i, p;
    int n = s.size();
    for (int i = 0; i < n; ++i) {
        str[i + 1] = s[i];
    }
    for (int i = 1; i <= n; ++i) {
        sa[i] = i;
        rk[i] = str[i];
    }

    for (w = 1; w < n; w <<= 1) {
        sort(sa + 1, sa + n + 1, [](int x, int y) {
            return rk[x] == rk[y] ? rk[x + w] < rk[y + w] : rk[x] < rk[y];
        });
        memcpy(oldrk, rk, sizeof(rk));
        for (int p = 0, i = 1; i <= n; ++i) {
            if (oldrk[sa[i]] == oldrk[sa[i - 1]] &&
                oldrk[sa[i] + w] == oldrk[sa[i - 1] + w]) {
                rk[sa[i]] = p;
            } else {
                rk[sa[i]] = ++p;
            }
        }
    }
    if (n == 1) rk[1] = 1;

    // 处理 height 数组
    for (int i = 1, k = 0; i <= n; ++i) {
        if (rk[i] == 0) continue;
        if (k) --k;
        while (str[i + k] == str[sa[rk[i] - 1] + k]) ++k;
        height[rk[i]] = k;
    }

    for (int i = 0; i < n; ++i) sa[i] = sa[i + 1] - 1;
    for (int i = 0; i < n; ++i) rk[i] = rk[i + 1] - 1;
    if (n == 1) rk[0] = 0;
    for (int i = 0; i < n; ++i) height[i] = height[i + 1];
}

template<typename T>
class SparseTable {
    using VT = vector<T>;
    using VVT = vector<VT>;
    using func_type = function<T(const T &, const T &)>;

    VVT ST;

    static T default_func(const T &t1, const T &t2) { return min(t1, t2); }

    func_type op;

public:
    SparseTable(const vector<T> &v, func_type _func = default_func) {
        op = _func;
        int len = v.size(), l1 = ceil(log2(len)) + 1;
        ST.assign(len, VT(l1, 0));
        for (int i = 0; i < len; ++i) {
            ST[i][0] = v[i];
        }
        for (int j = 1; j < l1; ++j) {
            int pj = 1 << (j - 1);
            for (int i = 0; i + pj < len; ++i) {
                ST[i][j] = op(ST[i][j - 1], ST[i + pj][j - 1]);
            }
        }
    }

    T query(int l, int r) {
        int lt = r - l + 1;
        int q = floor(log2(lt));
        return op(ST[l][q], ST[r - (1 << q) + 1][q]);
    }
};

int pre_sum(vector<int> &pre, int l, int r) {
    if (l) return pre[r] - pre[l - 1];
    return pre[r];
}

void solve() {
    int n, q;
    cin >> n >> q;

    string s;
    cin >> s;
    pre = vector<int>(n, s[0] == '1');
    for (int i = 1; i < n; ++i) {
        pre[i] = pre[i - 1] + (s[i] - '0');
    }
    getsa(s);
    SparseTable<int> st(height);

    while (q--) {
        int p, l, r;
        cin >> p >> l >> r;
        p--;
        l--;
        r--;

        int lp = rk[p], rp = n;
        // 找 [p:l] 的左右端点
        int len = l - p + 1;
        while (lp + 1 != rp) {
            int mp = (lp + rp) >> 1;
            int lcp = 0;
            if (sa[mp] + len - 1 >= n) {
                rp = mp;
                continue;
            }
            lcp = st.query(rk[p] + 1, mp);
            if (lcp >= len) lp = mp;
            else rp = mp;
        }
        int R = lp;

        lp = -1, rp = rk[p];
        len = l - p + 1;
        while (lp + 1 != rp) {
            int mp = (lp + rp) >> 1;
            int lcp = 0;
            if (sa[mp] + len - 1 >= n) {
                lp = mp;
                continue;
            }
            lcp = st.query(mp + 1, rk[p]);
            if (lcp >= len) rp = mp;
            else lp = mp;
        }
        int L = rp;

        lp = L, rp = R;
        ll ans = 0;
        for (int j = l; j <= r; ++j) {
            int len = j - p + 1;
            while (lp < n && sa[lp] + len - 1 > n || s[sa[lp] + len - 1] != s[j]) { lp++; }
            while (rp < n && sa[rp] + len - 1 > n || s[sa[rp] + len - 1] != s[j]) { rp--; }
            if (lp > rp) break;
            ans += (rp - lp + 1) * pre_sum(pre, p, j);
        }
        cout << ans << endl;
    }
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
降维打击【算法赛】
 */