#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int timeToSeconds(const string &timeStr) {
    int h, m, s;
    char c;
    istringstream ss(timeStr);
    ss >> h >> c >> m >> c >> s;
    return h * 3600 + m * 60 + s;
}

string solve() {
    string s1, s2, s3, s4;
    int T, x;
    cin >> s1 >> s2 >> s3 >> s4;
    cin >> T >> x;

    int t1 = timeToSeconds(s1);
    int t2 = timeToSeconds(s2);
    int t3 = timeToSeconds(s3);
    int t4 = timeToSeconds(s4);

    bool ok1 = true;
    bool ok2 = true;
    bool broom = false;

    if (t1 > t2) ok1 = false;
    if (t3 > t4) ok2 = false;
    if (t1 + 60 * x <= t2) broom = true;
    if (t1 <= t2 && t2 + 60 * T > t4) ok2 = false;

    if (broom || (ok1 && !ok2)) return "You";
    if (!ok1 && !ok2) return "Draw";
    return "Lan";
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
    cin >> t;
    while (t--) cout << solve() << endl;
    return 0;
}
/*
扫把扶不扶【算法赛】

计算你在扶起扫把后最早可能的面试开始时间。
如果该时间不超过 S2，则你可以扶起扫把并参加面试，你必定胜出。
如果该时间超过 S2，则你无法同时扶起扫把并完成面试。在这种情况下，你只能选择专注于面试，并应将面试开始时间尽可能推迟到 S2，使得小蓝最早面试时间为 S2+T。
如果 S2+T > S4，则小蓝无法参加面试，你获胜。否则，小蓝有机会参加面试，你将失败。
当然，由于数据并不保证 S1<=S2, S3<=S4，因此我们还需进一步判断 S1, S2, S3, S4 的大小关系，来确认双方是否能参加面试。
 */