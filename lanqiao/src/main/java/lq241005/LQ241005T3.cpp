#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    string s = "L";
    string input;
    cin >> input;
    s += input;

    int n = s.length();
    int ans = 0;
    for (int i = 2; i < n; ++i) {
        if (s[i] == 'L') {
            ans += 1;
        } else if (s[i - 1] == 'L' && s[i - 2] == 'L') {
            ans += 1;
        }
    }
    if (s.find("QQ") != string::npos) {
        ans += 1;
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
青铜门上的涂鸦【算法赛】

枚举连续两个字符，可以先进行分类讨论，有四种情况，*LL, *QL, *LQ, *QQ，最后一种暂时可以忽略，* 表示前面一个字符。
*LL 可以涂成 QQL 和 *QQ，第二种涂法和第一种不同，所以数量 +1。
*QL 可以涂成 QQL 和 *QQ，第二种涂法和第一种不同，所以数量 +1。
*LQ 可以涂成 QQQ 和 *QQ，如果 * 为 Q 数量不变，否则就数量 +1。
对于前两个字符，我们可以在前面添加一个 L，这样就不会影响结果。
最后，如果字符串中含有 QQ，涂一次虽然没有改变，但是也是一种涂法，所以数量 +1。
 */