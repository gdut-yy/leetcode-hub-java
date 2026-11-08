public class Solution4103 {
    public boolean canRemoveAll(int[] types, int[] colors, int[] groupSize) {
        int n = types.length;
        long[] stkKey = new long[n];
        int[] stkCnt = new int[n];
        int top = 0;

        for (int i = 0; i < n; i++) {
            long key = ((long) types[i] << 17) | colors[i];

            if (top > 0 && stkKey[top - 1] == key) {
                stkCnt[top - 1]++;
            } else {
                stkKey[top] = key;
                stkCnt[top] = 1;
                top++;
            }
            int type = (int) (stkKey[top - 1] >>> 17);
            if (stkCnt[top - 1] == groupSize[type]) {
                top--;
            }
        }
        return top == 0;
    }
}
/*
4103. 按类型和颜色删除元素
https://leetcode.cn/problems/remove-elements-by-type-and-color/description/

第 195 场双周赛 T2。

给你三个整数数组 types、colors 和 groupSize，其中 types 和 colors 的长度为 n，groupSize 的长度为 m。
- types[i] 表示下标 i 处元素的类型。
- colors[i] 表示下标 i 处元素的颜色。
- groupSize[t] 表示类型为 t 的删除组需要的元素数量。
在一次操作中，如果 恰好 groupSize[t] 个 连续 元素都具有类型 t 且颜色 相同 ，你可以将它们移除。
在每次移除后，剩余的元素会重新 相邻 ，同时保持它们的相对顺序。
如果可以通过一系列有效操作移除所有元素，返回 true。否则，返回 false。
示例 1：
输入： types = [0,1,1,0], colors = [5,3,3,5] , groupSize = [2,2]
输出： true
示例 2：
输入： types = [0,1,0], colors = [9,9,9], groupSize = [3,2]
输出： false
示例 3：
输入： types = [2,0,1,2], colors = [7,5,4,7], groupSize = [3,1,2]
输出： false
提示：
1 <= n == types.length == colors.length <= 10^5
1 <= m == groupSize.length <= 10^5
0 <= types[i] <= m - 1
1 <= colors[i] <= 10^5
1 <= groupSize[t] <= n

栈模拟。
时间复杂度 O(n)。
 */