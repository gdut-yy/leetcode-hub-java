public class Solution3889 {
    public int mirrorFrequency(String s) {
        int[] cnt = new int['z' + 1];
        for (char c : s.toCharArray()) {
            cnt[c]++;
        }

        int ans = 0;
        for (int i = 0; i < 13; i++) {
            ans += Math.abs(cnt['a' + i] - cnt['z' - i]);
        }
        for (int i = 0; i < 5; i++) {
            ans += Math.abs(cnt['0' + i] - cnt['9' - i]);
        }
        return ans;
    }
}
/*
3889. 镜像频次距离
https://leetcode.cn/problems/mirror-frequency-distance/description/

第 496 场周赛 T1。

给你一个由小写英文字母和数字组成的字符串 s。
对于每个字符，其 镜像字符 根据逆序定义其字符集合：
- 对于字母，某字符的镜像字符是字母表中从末尾与其位置相同的字母。
  - 例如，'a' 的镜像字符是 'z'，'b' 的镜像字符是 'y'，以此类推。
- 对于数字，某字符的镜像字符是范围 '0' 到 '9' 中从末尾与其位置相同的数字。
  - 例如，'0' 的镜像字符是 '9'，'1' 的镜像字符是 '8'，以此类推。
对于字符串中每个 唯一 字符 c：
- 设 m 为其 镜像字符 。
  - 设 freq(x) 表示字符 x 在字符串中出现的次数。
- 计算其与镜像字符出现次数之间的 绝对差，定义为：|freq(c) - freq(m)|
  - 镜像对 (c, m) 和 (m, c) 被视为相同，只能被计算 一次 。
返回一个整数，表示所有这些 不同的镜像对 的绝对差之和。
提示:
1 <= s.length <= 5 * 10^5
s 仅由小写英文字母和数字组成。

中国时间 2026-04-05 周日 10:30
深圳。清明假期。
模拟。
时间复杂度：O(n)。
 */