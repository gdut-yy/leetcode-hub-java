import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution3597 {
    public List<String> partitionString(String s) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        int i = 0;
        while (i < n) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                if (!set.contains(sub)) {
                    set.add(sub);
                    ans.add(sub);
                    i = j - 1;
                    break;
                }
            }
            i++;
        }
        return ans;
    }
}
/*
3597. 分割字符串
https://leetcode.cn/problems/partition-string/description/

第 456 场周赛 T1。

给你一个字符串 s，按照以下步骤将其分割为 互不相同的段 ：
从下标 0 开始构建一个段。
逐字符扩展当前段，直到该段之前未曾出现过。
只要当前段是唯一的，就将其加入段列表，标记为已经出现过，并从下一个下标开始构建新的段。
重复上述步骤，直到处理完整个字符串 s。
返回字符串数组 segments，其中 segments[i] 表示创建的第 i 段。
提示：
1 <= s.length <= 10^5
s 仅包含小写英文字母。

哈希表模拟。
时间复杂度 O(n * sqrt(n))
 */