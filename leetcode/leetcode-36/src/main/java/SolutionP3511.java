import java.util.ArrayList;
import java.util.List;

public class SolutionP3511 {
    public int makeArrayPositive(int[] nums) {
        List<Long> s = new ArrayList<>();
        s.add(0L);
        int ans = 0, j = 0;
        long pre_mx = 0;
        for (int i = 1; i <= nums.length; i++) {
            int x = nums[i - 1];
            s.add(s.getLast() + x);
            if (i - j > 2 && s.getLast() - pre_mx <= 0) {
                ans++;
                j = i;
                pre_mx = 0;
                s.removeLast();
                s.add(0L);
            } else if (i - j >= 2) {
                pre_mx = Math.max(pre_mx, s.get(i - 2));
            }
        }
        return ans;
    }
}
/*
$3511. 构造正数组
https://leetcode.cn/problems/make-a-positive-array/description/

给定一个数组 nums。一个数组被认为是 正 的，如果每个包含 超过两个 元素的 子数组 的所有数字之和都是正数。
您可以执行以下操作任意多次：
- 用 -10^18 和 10^18 之间的任意整数替换 nums 中的 一个 元素。
找到使 nums 变为正数组所需的最小操作数。
提示：
3 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

前缀和。
https://leetcode.cn/problems/make-a-positive-array/solutions/3643874/qian-zhui-he-by-13126731116-kpsy/
 */