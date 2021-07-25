import java.util.ArrayList;
import java.util.List;

public class Solution830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        // s 仅含小写英文字母。末位补 0 防止越界
        s = s + "0";
        List<List<Integer>> ans = new ArrayList<>();
        // 双指针
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            // 字符相等 右指针往右移
            if (s.charAt(left) == s.charAt(right)) {
                right++;
            }
            // 字符不等 计算差值，若大于等于 3 则进行记录
            else {
                int between = right - left;
                if (between >= 3) {
                    // jdk11
                    List<Integer> beginEnd = List.of(left, right - 1);
                    ans.add(beginEnd);
                }
                // 左指针移至右指针位置
                left = right;
            }
        }
        return ans;
    }
}
/*
830. 较大分组的位置
https://leetcode-cn.com/problems/positions-of-large-groups/

第 83 场周赛 T1。
类双指针。末位补 0 防止越界。注意 List.of() 写法
 */