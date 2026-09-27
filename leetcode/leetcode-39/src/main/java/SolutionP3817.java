import java.util.ArrayList;
import java.util.List;

public class SolutionP3817 {
    public List<Integer> goodIndices(String s) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            // 将下标 i 转为字符串，检查是否出现在 s 中的对应位置
            String toMatch = Integer.toString(i);
            int start = i + 1 - toMatch.length();
            if (start >= 0 && start + toMatch.length() <= s.length()
                    && s.startsWith(toMatch, start)) {
                res.add(i);
            }
        }
        return res;
    }
}
/*
$3817. 数字字符串中的好索引
https://leetcode.cn/problems/good-indices-in-a-digit-string/description/

给定一个由数字组成的字符串 s。
如果存在一个 子串，它以索引 i 结尾并且等于 i 的十进制表示，则称索引 i 为好索引。
返回一个包含所有好索引的整数数组，并按 升序排列。
示例 1：
输入：s = "0234567890112"
输出：[0,11,12]
示例 2：
输入：s = "01234"
输出：[0,1,2,3,4]
示例 3：
输入：s = "12345"
输出：[]
提示：
1 <= s.length <= 10^5
s 只包含 '0' 到 '9' 的数字。
 */