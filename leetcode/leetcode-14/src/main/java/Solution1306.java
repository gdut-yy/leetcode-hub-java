import java.util.ArrayDeque;
import java.util.Queue;

public class Solution1306 {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        boolean[] vis = new boolean[n];
        vis[start] = true;
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int i = q.remove();
                if (arr[i] == 0) {
                    return true;
                }
                // 可以跳到 i + arr[i] 或者 i - arr[i]
                for (int j : new int[]{i + arr[i], i - arr[i]}) {
                    if (0 <= j && j < n && !vis[j]) {
                        vis[j] = true;
                        q.add(j);
                    }
                }
            }
        }
        return false;
    }
}
/*
1306. 跳跃游戏 III
https://leetcode.cn/problems/jump-game-iii/

这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
注意，不管是什么情况下，你都无法跳到数组之外。
提示：
1 <= arr.length <= 5 * 10^4
0 <= arr[i] < arr.length
0 <= start < arr.length

BFS。
 */