public class SolutionLCR139 {
    public int[] trainingPlan(int[] actions) {
        // 双指针
        int left = 0;
        int right = actions.length - 1;
        while (left < right) {
            // left 找偶数
            while (left < right && actions[left] % 2 == 1) {
                left++;
            }
            // right 找奇数
            while (left < right && actions[right] % 2 == 0) {
                right--;
            }
            // swap
            int tmp = actions[left];
            actions[left] = actions[right];
            actions[right] = tmp;
        }
        return actions;
    }
}
/*
LCR 139. 训练计划 I
https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/description/

教练使用整数数组 actions 记录一系列核心肌群训练项目编号。为增强训练趣味性，需要将所有奇数编号训练项目调整至偶数编号训练项目之前。请将调整后的训练项目编号以 数组 形式返回。
提示：
0 <= actions.length <= 50000
0 <= actions[i] <= 10000

双指针。
 */
