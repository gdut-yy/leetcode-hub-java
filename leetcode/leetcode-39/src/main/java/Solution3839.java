import java.util.HashMap;
import java.util.Map;

public class Solution3839 {
    public int prefixConnected(String[] words, int k) {
        Map<String, Integer> mp = new HashMap<>();
        for (String s : words) {
            if (s.length() < k) continue;
            String prefix = s.substring(0, k);
            mp.merge(prefix, 1, Integer::sum);
        }
        int ans = 0;
        for (Integer c : mp.values()) {
            if (c >= 2) ans++;
        }
        return ans;
    }
}
/*
3839. 前缀连接组的数目
https://leetcode.cn/problems/number-of-prefix-connected-groups/description/

第 176 场双周赛 T2。

给你一个字符串数组 words 和一个整数 k。
如果两个位于 不同下标 的单词 a 和 b 满足 a[0..k-1] == b[0..k-1]，则称它们是 前缀连接的。
一个 连接组 是指一组单词，其中每对单词都是前缀连接的。
返回从给定的单词中形成包含 至少 两个单词的 连接组数目 。
注意：
- 长度小于 k 的单词不能加入任何组，应被忽略。
- 重复的字符串被视为不同的单词。
- 字符串的 前缀 是指从字符串开头开始并延伸到其中任意位置的子字符串。
提示：
1 <= words.length <= 5000
1 <= words[i].length <= 100
1 <= k <= 100
words 中的所有字符串均由小写英文字母组成。

哈希表统计。
时间复杂度 O(nk)。
 */