import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ubiquant220821T4 {
    private int kind;
    private int[] target;
    private Map<String, Double> memo;

    public double chipGame(int[] nums, int kind) {
        this.kind = kind;
        // 将目标数组降序排序
        int[] arr = nums.clone();
        Arrays.sort(arr);
        target = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            target[i] = arr[arr.length - 1 - i];
        }
        memo = new HashMap<>();
        List<Integer> init = new ArrayList<>();
        return dfs(init);
    }

    private double dfs(List<Integer> current) {
        // 如果当前状态与目标完全一致，返回 0
        if (current.size() == target.length) {
            boolean equal = true;
            for (int i = 0; i < target.length; i++) {
                if (current.get(i) != target[i]) {
                    equal = false;
                    break;
                }
            }
            if (equal) return 0.0;
        }

        String key = current.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int len = current.size();
        int U = kind - len; // 未选面值的数量
        int N = 0; // 允许接受的面值总数（包括已选和未选）
        List<List<Integer>> nextStates = new ArrayList<>();
        List<Integer> weights = new ArrayList<>();

        // 1. 尝试增加已选面值
        for (int i = 0; i < len; i++) {
            List<Integer> newCurrent = new ArrayList<>(current);
            newCurrent.set(i, newCurrent.get(i) + 1);
            newCurrent.sort(Collections.reverseOrder());
            if (isValid(newCurrent)) {
                nextStates.add(newCurrent);
                weights.add(1);
                N += 1;
            }
        }

        // 2. 尝试创建新面值（仅当当前堆数小于目标堆数时）
        if (len < target.length) {
            List<Integer> newCurrent = new ArrayList<>(current);
            newCurrent.add(1);
            newCurrent.sort(Collections.reverseOrder());
            if (isValid(newCurrent)) {
                nextStates.add(newCurrent);
                weights.add(U);
                N += U;
            }
        }

        if (N == 0) {
            // 理论上不会发生，除非目标不可达
            return 0.0;
        }

        double eSuccess = 0.0;
        for (int i = 0; i < nextStates.size(); i++) {
            List<Integer> next = nextStates.get(i);
            int weight = weights.get(i);
            eSuccess += (double) weight / N * dfs(next);
        }

        double result = (double) kind / N + eSuccess;
        memo.put(key, result);
        return result;
    }

    // 检查当前列表（降序）是否是目标数组（降序）的子多重集
    private boolean isValid(List<Integer> current) {
        for (int i = 0; i < current.size(); i++) {
            if (current.get(i) > target[i]) {
                return false;
            }
        }
        return true;
    }
}
/*
九坤-04. 筹码游戏
https://leetcode.cn/contest/ubiquant2022/problems/I3Gm2h/

九坤很喜欢玩德州扑克，但是有一个神奇的周五，大家都去加班了，于是九坤只能研究起了桌上的筹码。
他把所有的筹码都放入了一个纸箱中，并按以下规则向外抽取筹码：
- 每次抽取仅取出 1 个筹码
- 如果对本次取出的筹码不满意，会将该筹码放回并重新抽取，直到确定想要这个筹码。
- 对于取出的筹码，他会将相同面值的筹码放在一堆
  -例如：抽取了 6 个筹码，3 个 10，2 个 5，1个 1，那么他就会把这些筹码放成三堆，数量分别是3、2、1。
纸箱中共有 kind 种面值的筹码。现给定九坤取出筹码的最终目标为 nums， nums[i] 表示第 i 堆筹码的数量。
假设每种面值的筹码都有无限多个，且九坤总是遵循最优策略，使得他达成目标的操作次数最小化。
请返回九坤达成目标的情况下，需要取出筹码次数的期望值。
注意：
最终取出的筹码中，对于任意两堆筹码的面值都是不同的。
不需要考虑筹码堆的顺序（例如，[3,1,1]、[1,1,3] 这两个筹码堆是相同的）
示例 1:
输入：
nums = [1,1]
kind = 2
输出：3.00000
解释：共有 2 种筹码，初始取出的数量为 [0,0]
第一次取出筹码后，筹码数量为 [1,0]，此时取了 1 次
第二次取出筹码后，筹码数量为 [2,0] 和 [1,1] 的概率均为 0.5
因此，在 [1,0] 的基础上取出 [1,1] 的次数期望值为 2
总期望值为 1+2=3
示例 2:
输入：
nums = [1,2]
kind = 4
输出：3.833333
解释：1 + 1 + 1/4 * 4/3 + 3/4 * 4/2 = 23 / 6
提示：
1 <= kind <= 50
1 <= nums.length <= kind
sum(nums[0],nums[1],...,nums[n]) <= 50
 */