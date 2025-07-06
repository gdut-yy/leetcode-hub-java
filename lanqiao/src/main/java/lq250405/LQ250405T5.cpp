#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;

    vector<int> t1(n), t2(n);
    for (int i = 0; i < n; ++i) {
        cin >> t1[i];
    }
    for (int i = 0; i < n; ++i) {
        cin >> t2[i];
    }

    vector<pair<int, int> > gifts(n);
    for (int i = 0; i < n; ++i) {
        gifts[i] = {t1[i], t2[i]};
    }

    vector<pair<int, int> > groupA, groupB;
    for (const auto &gift: gifts) {
        if (gift.first <= gift.second) {
            groupA.push_back(gift);
        } else {
            groupB.push_back(gift);
        }
    }

    sort(groupA.begin(), groupA.end(),
         [](const pair<int, int> &a, const pair<int, int> &b) {
             return a.first < b.first;
         });
    sort(groupB.begin(), groupB.end(),
         [](const pair<int, int> &a, const pair<int, int> &b) {
             return a.second > b.second;
         });

    // 合并组A和组B
    vector<pair<int, int> > sorted_gifts;
    sorted_gifts.insert(sorted_gifts.end(), groupA.begin(), groupA.end());
    sorted_gifts.insert(sorted_gifts.end(), groupB.begin(), groupB.end());

    // 计算总时间
    int sum_t1 = 0;
    for (const auto &gift: sorted_gifts) {
        sum_t1 += gift.first;
    }

    int santa_end = 0;
    int current_pack_time = 0;
    for (const auto &gift: sorted_gifts) {
        current_pack_time += gift.first;
        int start = max(current_pack_time, santa_end);
        santa_end = start + gift.second;
    }

    int total_time = max(sum_t1, santa_end);
    cout << total_time << endl;
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
破译密码【算法赛】
 */