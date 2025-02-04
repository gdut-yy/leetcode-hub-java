#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int f(string &s, char x) {
    int n = s.length();
    int res = n;
    int i = 0;
    while (i < n) {
        if (s[i] != x) {
            i++;
            continue;
        }
        int st = i;
        for (i++; i < n && s[i] == x; i++) {};
        res -= (i - st - 1);
    }
    return res;
}

void solve() {
    string s;
    cin >> s;

    int ans = min(f(s, 'L'), f(s, 'Q'));
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
打开石门【算法赛】
 */