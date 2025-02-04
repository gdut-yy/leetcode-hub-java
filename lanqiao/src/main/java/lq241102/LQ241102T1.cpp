#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int decimalNum = 20241111;

    string binaryStr;
    while (decimalNum > 0) {
        binaryStr += (decimalNum % 2) ? '1' : '0';
        decimalNum /= 2;
    }
    std::reverse(binaryStr.begin(), binaryStr.end());

    cout << (binaryStr.empty() ? 0 : binaryStr) << endl;
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
动态密码【算法赛】
 */