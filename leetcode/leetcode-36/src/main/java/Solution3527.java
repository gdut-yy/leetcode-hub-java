import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3527 {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String, Integer> cnt = new HashMap<>();
        responses.forEach(list -> list.stream().distinct().forEach(v -> cnt.merge(v, 1, Integer::sum)));

        String ans = "";
        int maxCnt = 0;
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            if (entry.getValue() > maxCnt) {
                maxCnt = entry.getValue();
                ans = entry.getKey();
            } else if (entry.getValue() == maxCnt && ans.compareTo(entry.getKey()) > 0) {
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
/*
3527. 找到最常见的回答
https://leetcode.cn/problems/find-the-most-common-response/description/

第 155 场双周赛 T1。

给你一个二维字符串数组 responses，其中每个 responses[i] 是一个字符串数组，表示第 i 天调查的回答结果。
请返回在对每个 responses[i] 中的回答 去重 后，所有天数中 最常见 的回答。如果有多个回答出现频率相同，则返回 字典序最小 的那个回答。
提示：
1 <= responses.length <= 1000
1 <= responses[i].length <= 1000
1 <= responses[i][j].length <= 10
responses[i][j] 仅由小写英文字母组成

中国时间 2025-04-26 周六 22:30
广州·中肿。术后第2天。
哈希表计数。
时间复杂度 O(L)。
 */