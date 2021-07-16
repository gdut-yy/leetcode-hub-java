import java.util.List;

public class Solution1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int cnt = 0;
        for (List<String> item : items) {
            if ("type".equals(ruleKey)) {
                if (ruleValue.equals(item.get(0))) {
                    cnt++;
                }
            } else if ("color".equals(ruleKey)) {
                if (ruleValue.equals(item.get(1))) {
                    cnt++;
                }
            } else {
                if (ruleValue.equals(item.get(2))) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
/*
1773. 统计匹配检索规则的物品数量
https://leetcode-cn.com/problems/count-items-matching-a-rule/

周赛签到题。根据题意模拟即可。
 */