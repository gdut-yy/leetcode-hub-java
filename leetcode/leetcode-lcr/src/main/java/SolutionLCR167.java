import java.util.HashMap;
import java.util.Map;

public class SolutionLCR167 {
    public int dismantlingAction(String arr) {
        int n = arr.length(), l = 0, r = 0, ans = 0;
        Map<Character, Integer> cntMap = new HashMap<>();
        while (r < n) {
            cntMap.merge(arr.charAt(r), 1, Integer::sum);
            while (cntMap.get(arr.charAt(r)) > 1) {
                cntMap.merge(arr.charAt(l), -1, Integer::sum);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
/*
LCR 167. 招式拆解 I
https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/

某套连招动作记作序列 arr，其中 arr[i] 为第 i 个招式的名字。请返回 arr 中最多可以出连续不重复的多少个招式。
提示：
0 <= arr.length <= 40000
arr 由英文字母、数字、符号和空格组成。

同: 3. 无重复字符的最长子串
https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */