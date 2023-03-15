import java.util.HashSet;
import java.util.Set;

public class SolutionO61 {
    public boolean isStraight(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        // [0,13]
        int min = 14;
        int max = -1;
        int cnt0 = 0;
        for (int num : nums) {
            if (num > 0) {
                min = Math.min(min, num);
                max = Math.max(max, num);
                hashSet.add(num);
            } else {
                cnt0++;
            }
        }
        // 不可构成顺子
        // 最大值 - 最小值 >= 5（除去大小王）
        // 存在重复的牌（除去大小王）
        return (max - min < 5) && hashSet.size() + cnt0 == 5;
    }
}
/*
剑指 Offer 61. 扑克牌中的顺子
https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/

从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

除去大小王的前提下，以下两种情况不可构成顺子：
1.最大值 - 最小值 >= 5
2.存在重复的牌
 */