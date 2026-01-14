import java.util.HashMap;
import java.util.Map;

public class Solution3805 {
    public long countPairs(String[] words) {
        Map<String, Integer> mp = new HashMap<>();
        for (String w : words) {
            mp.merge(normalize(w), 1, Integer::sum);
        }
        long ans = 0;
        for (long c : mp.values()) {
            ans += c * (c - 1) / 2;
        }
        return ans;
    }

    private String normalize(String s) {
        int shift = (26 - (s.charAt(0) - 'a')) % 26;
        char[] ret = s.toCharArray();
        for (int i = 0; i < ret.length; i++) {
            int c = (ret[i] - 'a' + shift) % 26;
            ret[i] = (char) (c + 'a');
        }
        return new String(ret);
    }
}
/*
3805. 统计凯撒加密对数目
https://leetcode.cn/problems/count-caesar-cipher-pairs/description/

第 484 场周赛 T3。

给你一个由 n 个字符串组成的数组 words。每个字符串的长度均为 m 且仅包含小写英文字母。
如果我们可以通过执行以下操作任意次数（可能为零次）使得两个字符串 s 和 t 变得 相等，则称这两个字符串是 相似 的。
- 选择 s 或 t 。
- 将所选字符串中的 每个 字母替换为字母表中的下一个字母（循环替换）。'z' 之后的下一个字母是 'a'。
计算满足以下条件的下标对 (i, j) 的数量：
- i < j
- words[i] 和 words[j] 是 相似 的。
返回一个整数，表示此类下标对的数量。
提示：
1 <= n == words.length <= 10^5
1 <= m == words[i].length <= 10^5
1 <= n * m <= 10^5
words[i] 仅由小写英文字母组成。

规整化，哈希表计数。
时间复杂度 O(nm)。
 */