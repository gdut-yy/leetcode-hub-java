import java.util.Arrays;

public class SolutionI0813 {
    public int pileBox(int[][] box) {
        Arrays.sort(box, (o1, o2) -> {
            for (int i = 0; i < 3; i++) {
                if (o1[i] != o2[i]) {
                    return Integer.compare(o1[i], o2[i]);
                }
            }
            return 0;
        });

        int max = 0;
        int len = box.length;
        int[] f = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // 排序后，cuboids[j][0] <= cuboids[i][0] 恒成立
                if (box[j][0] < box[i][0] && box[j][1] < box[i][1] && box[j][2] < box[i][2]) {
                    // cuboids[j] 可以堆在 cuboids[i] 上
                    f[i] = Math.max(f[i], f[j]);
                }
            }
            f[i] += box[i][2];
            max = Math.max(max, f[i]);
        }
        return max;
    }
}
/*
面试题 08.13. 堆箱子
https://leetcode.cn/problems/pile-box-lcci/

堆箱子。给你一堆n个箱子，箱子宽 wi、深 di、高 hi。箱子不能翻转，将箱子堆起来时，下面箱子的宽度、高度和深度必须大于上面的箱子。实现一种方法，搭出最高的一堆箱子。箱堆的高度为每个箱子高度的总和。
输入使用数组[wi, di, hi]表示每个箱子。
提示:
箱子的数目不大于3000个。

注意是大于。
相似题目: 1691. 堆叠长方体的最大高度
https://leetcode.cn/problems/maximum-height-by-stacking-cuboids/
 */