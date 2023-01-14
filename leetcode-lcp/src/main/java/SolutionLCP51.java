public class SolutionLCP51 {
    private int[] materials;
    private int[][] cookbooks;
    private int[][] attribute;
    private int limit;
    private int len;

    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        this.materials = materials;
        this.cookbooks = cookbooks;
        this.attribute = attribute;
        this.limit = limit;
        len = cookbooks.length;

        // 状态压缩 2^8 = 256
        int max = -1;
        for (int mask = 0; mask < (1 << len); mask++) {
            int delicious = getDeliciousByMask(mask);
            max = Math.max(max, delicious);
        }
        return max;
    }

    private int getDeliciousByMask(int mask) {
        int[] materialsCopy = materials.clone();
        // 美味度
        int delicious = 0;
        // 饱腹感
        int satiety = 0;

        for (int k = 0; k < len; k++) {
            // 第 k 位被选中
            if (((mask >> k) & 1) == 1) {
                // 编号为 0 ~ 4 的五种食材
                for (int j = 0; j < 5; j++) {
                    materialsCopy[j] -= cookbooks[k][j];
                    if (materialsCopy[j] < 0) {
                        if (satiety >= limit) {
                            return delicious;
                        } else {
                            return -1;
                        }
                    }
                }
                delicious += attribute[k][0];
                satiety += attribute[k][1];
            }
        }
        if (satiety >= limit) {
            return delicious;
        } else {
            return -1;
        }
    }
}
/*
LCP 51. 烹饪料理
https://leetcode.cn/problems/UEcfPD/

LCCUP 力扣杯 2022 春季编程大赛个人赛 T2。

欢迎各位勇者来到力扣城，城内设有烹饪锅供勇者制作料理，为自己恢复状态。
勇者背包内共有编号为 0 ~ 4 的五种食材，其中 materials[j] 表示第 j 种食材的数量。通过这些食材可以制作若干料理，
cookbooks[i][j] 表示制作第 i 种料理需要第 j 种食材的数量，而 attribute[i] = [x,y] 表示第 i 道料理的美味度 x 和饱腹感 y。
在饱腹感不小于 limit 的情况下，请返回勇者可获得的最大美味度。如果无法满足饱腹感要求，则返回 -1。
注意：
每种料理只能制作一次。
提示：
materials.length == 5
1 <= cookbooks.length == attribute.length <= 8
cookbooks[i].length == 5
attribute[i].length == 2
0 <= materials[i], cookbooks[i][j], attribute[i][j] <= 20
1 <= limit <= 100

暴力/状态压缩
数据范围很小，只有 2^8 = 256
 */