import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3999 {
    public int minimumGroups(String[] words) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String w : words) {
            String e = extract(w, 0);
            String o = extract(w, 1);
            String key = minRotation(e) + "|" + minRotation(o);
            cnt.merge(key, 1, Integer::sum);
        }
        return cnt.size();
    }

    private String extract(String s, int start) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < s.length(); i += 2) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private String minRotation(String s) {
        if (s.length() <= 1) return s;
        int n = s.length();
        String s2 = s + s;
        int m = 2 * n;
        int[] f = new int[m];
        Arrays.fill(f, -1);
        int k = 0;
        for (int j = 1; j < m; j++) {
            int i = f[j - k - 1];
            char cj = s2.charAt(j);
            while (i != -1 && cj != s2.charAt(k + i + 1)) {
                if (cj < s2.charAt(k + i + 1)) {
                    k = j - i - 1;
                }
                i = f[i];
            }
            if (i == -1 && cj != s2.charAt(k)) {
                if (cj < s2.charAt(k)) {
                    k = j;
                }
                f[j - k] = -1;
            } else {
                f[j - k] = i + 1;
            }
        }
        return s2.substring(k, k + n);
    }
}
/*
3999. 字符串变换后的最少分组数
https://leetcode.cn/problems/minimum-number-of-string-groups-through-transformations/description/

第 511 场周赛 T4。

给你一个字符串数组 words。
定义对字符串 s 的一次 变换 如下：
- 令 E 为 s 中位于偶数下标处字符组成的 子序列。
- 令 O 为 s 中位于奇数下标处字符组成的 子序列。
- 分别将 E 和 O 向右循环移动 任意 个位置，移动次数可以为 0。
- 将移动后的 E 中的字符依次放回偶数下标，将移动后的 O 中的字符依次放回奇数下标，从而重新构造字符串。
如果一个字符串可以通过 一次 变换得到另一个字符串，则称这两个字符串 等价 。
将 words 划分为 最少 数量的组，并满足：
- 每个字符串 恰好 属于一个组。
- 同一组中的任意两个字符串都 等价。
返回一个整数，表示所需的 最少 分组数量。
子序列 是指通过删除一个序列中的某些元素或不删除任何元素，并且不改变剩余元素相对顺序后得到的序列。
提示：
1 <= words.length <= 10^5
1 <= words[i].length <= 5 * 10^5
所有 words[i].length 之和不超过 5 * 10^5。
words[i] 仅由小写英文字母组成。

最小表示法。
时间复杂度 O(L)。其中 L 是所有字符串的长度之和。
 */