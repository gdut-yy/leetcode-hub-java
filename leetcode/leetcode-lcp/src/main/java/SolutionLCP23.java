public class SolutionLCP23 {
    // https://leetcode.cn/problems/er94lq/solution/mo-ni-xi-pai-guo-cheng-xiang-xi-fen-xi-li-jie-kde-/
    public boolean isMagic(int[] target) {
        int len = target.length;

        // 构造数组 {1,2,3,4....n}
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = i + 1;
        }

        nums = magicSort(nums, len);
        int k = getLen(nums, target);
        if (k == 0) {
            return false;
        }

        int numsLen = len;
        while (numsLen > 0) {
            // 取走前k个数
            for (int i = k; i < numsLen; i++) {
                nums[i - k] = nums[i];
                target[i - k] = target[i];
            }
            if (numsLen > k) {
                numsLen -= k;
            } else {
                numsLen = 0;
            }
            if (numsLen == 0) {
                return true;
            }
            nums = magicSort(nums, numsLen);
            for (int i = 0; i < k && i < numsLen; i++) {
                if (nums[i] != target[i]) {
                    return false;
                }
            }
        }
        return false;
    }

    // 洗牌过程
    private int[] magicSort(int[] nums, int length) {
        int[] result = new int[length];
        int mid = length / 2;
        for (int i = 0, even = 0, odd = mid; i < length; i++) {
            if ((i + 1) % 2 == 0) {
                result[even++] = nums[i];
            } else {
                result[odd++] = nums[i];
            }
        }
        return result;
    }

    private int getLen(int[] firstSort, int[] target) {
        int n = firstSort.length;
        for (int i = 0; i < n; i++) {
            if (firstSort[i] != target[i]) {
                return i;
            }
        }
        // 两个数组完全相等，返回 n
        return n;
    }
}
/*
LCP 23. 魔术排列
https://leetcode.cn/problems/er94lq/

秋日市集上，魔术师邀请小扣与他互动。魔术师的道具为分别写有数字 1~N 的 N 张卡牌，然后请小扣思考一个 N 张卡牌的排列 target。
魔术师的目标是找到一个数字 k（k >= 1），使得初始排列顺序为 1~N 的卡牌经过特殊的洗牌方式最终变成小扣所想的排列 target，特殊的洗牌方式为：
- 第一步，魔术师将当前位于 偶数位置 的卡牌（下标自 1 开始），保持 当前排列顺序 放在位于 奇数位置 的卡牌之前。
例如：将当前排列 [1,2,3,4,5] 位于偶数位置的 [2,4] 置于奇数位置的 [1,3,5] 前，排列变为 [2,4,1,3,5]；
- 第二步，若当前卡牌数量小于等于 k，则魔术师按排列顺序取走全部卡牌；若当前卡牌数量大于 k，则取走前 k 张卡牌，剩余卡牌继续重复这两个步骤，直至所有卡牌全部被取走；
卡牌按照魔术师取走顺序构成的新排列为「魔术取数排列」，请返回是否存在这个数字 k 使得「魔术取数排列」恰好就是 target，从而让小扣感到大吃一惊。
提示：
1 <= target.length = N <= 5000
题目保证 target 是 1~N 的一个排列。
 */