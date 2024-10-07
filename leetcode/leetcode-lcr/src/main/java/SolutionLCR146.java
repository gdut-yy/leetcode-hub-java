public class SolutionLCR146 {
    public int[] spiralArray(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) return new int[0];

        int m = array.length;
        int n = array[0].length;
        int[] ans = new int[m * n];
        int idx = 0;
        int left = 0;
        int up = 0;
        int right = n - 1;
        int down = m - 1;
        while (left <= right && up <= down) {
            // 左到右
            for (int j = left; j <= right; j++) {
                ans[idx] = array[up][j];
                idx++;
            }
            // 上到下
            for (int i = up + 1; i <= down; i++) {
                ans[idx] = array[i][right];
                idx++;
            }
            if (left < right && up < down) {
                // 右到左
                for (int j = right - 1; j > left; j--) {
                    ans[idx] = array[down][j];
                    idx++;
                }
                // 下到上
                for (int i = down; i > up; i--) {
                    ans[idx] = array[i][left];
                    idx++;
                }
            }
            left++;
            right--;
            up++;
            down--;
        }
        return ans;
    }
}
/*
LCR 146. 螺旋遍历二维数组
https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/description/

给定一个二维数组 array，请返回「螺旋遍历」该数组的结果。
螺旋遍历：从左上角开始，按照 向右、向下、向左、向上 的顺序 依次 提取元素，然后再进入内部一层重复相同的步骤，直到提取完所有元素。
限制：
0 <= array.length <= 100
0 <= array[i].length <= 100

同: 54. 螺旋矩阵
https://leetcode.cn/problems/spiral-matrix/
 */