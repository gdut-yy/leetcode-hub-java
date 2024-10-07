import java.util.HashMap;
import java.util.Map;

public class SolutionLCR178 {
    public int trainingPlan(int[] actions) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : actions) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
/*
LCR 178. 训练计划 VI
https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/description/

教学过程中，教练示范一次，学员跟做三次。该过程被混乱剪辑后，记录于数组 actions，其中 actions[i] 表示做出该动作的人员编号。请返回教练的编号。
提示：
1 <= actions.length <= 10000
1 <= actions[i] < 2^31

同: 137. 只出现一次的数字 II
https://leetcode.cn/problems/single-number-ii/
 */