#include <bits/stdc++.h>

using namespace std;
//typedef long long ll;
#define int long long

const int N = 1e5 + 10;

struct node {
    int k, id, ans;

    bool operator<(const node &x) const {
        if (k == x.k) return id < x.id;
        return k < x.k;
    }
} Q[N];

bool cmp(node a, node b) {
    return a.id < b.id;
}

int a[N];

void solve() {
    int n, q;
    cin >> n >> q;

    for (int i = 1; i <= n; ++i) {
        cin >> a[i];
    }
    for (int i = 1; i <= q; ++i) {
        cin >> Q[i].k;
        Q[i].id = i; // 记录原始询问顺序
    }
    sort(a + 1, a + 1 + n); // 对已有的头饰编号排序
    sort(Q + 1, Q + 1 + q); // 对询问按照 k 值排序

    int pre = 0; // pre 记录上一个头饰编号
    int j = 1; // j 指向当前处理的询问
    int sum = 0; // sum 记录累计的缺失编号数量
    for (int i = 1; i <= n; ++i) {
        int cha = a[i] - pre - 1;
        if (cha < 0) continue;

        // 如果当前缺失的数量 cha 大于等于当前询问 k，则可以直接计算出答案
        if (Q[j].k <= cha) {
            Q[j].ans = pre + Q[j].k;
            Q[j].k = 0;
            j++;
            i--;
            Q[j].k -= sum; // 这行代码是多余的？
            continue;
        }
        // 如果当前缺失的数量 cha 小于当前询问 k，则更新 k 和 sum
        Q[j].k -= cha;
        sum += cha;
        pre = a[i];
    }

    // 处理剩余的询问，这些询问对应的丫鬟编号都大于最大的已知头饰编号
    if (Q[j].k > 0) {
        Q[j].ans = pre + Q[j].k;
        j++;
    }
    for (int i = j; i <= q; ++i) {
        // 处理剩余的询问，这里不需要减去 sum，因为 sum 只记录到最后一个 a[i] 为止的缺失数量
        // 而剩余的询问的编号都大于 a[n]
        Q[i].ans = pre + Q[i].k;
        Q[i].ans -= sum;
//        cout << "ans:" << Q[i].ans << " sum:" << sum << endl;
    }

    sort(Q + 1, Q + 1 + q, cmp);
    for (int i = 1; i <= q; ++i) {
        cout << Q[i].ans << endl;
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
赏花宴【算法赛】
 */