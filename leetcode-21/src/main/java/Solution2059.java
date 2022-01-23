import java.util.LinkedList;
import java.util.Queue;

public class Solution2059 {
    public int minimumOperations(int[] nums, int start, int goal) {
        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        // 0 <= x <= 1000
        boolean[] visited = new boolean[1001];
        visited[start] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                Integer cur = queue.remove();
                for (int num : nums) {
                    int next1 = cur + num;
                    int next2 = cur - num;
                    int next3 = cur ^ num;
                    if (next1 == goal || next2 == goal || next3 == goal) {
                        return step;
                    } else {
                        if (next1 >= 0 && next1 <= 1000 && !visited[next1]) {
                            visited[next1] = true;
                            queue.add(next1);
                        }
                        if (next2 >= 0 && next2 <= 1000 && !visited[next2]) {
                            visited[next2] = true;
                            queue.add(next2);
                        }
                        if (next3 >= 0 && next3 <= 1000 && !visited[next3]) {
                            visited[next3] = true;
                            queue.add(next3);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
/*
2059. 转化数字的最小运算数
https://leetcode-cn.com/problems/minimum-operations-to-convert-number/

第 265 场周赛 T3。

给你一个下标从 0 开始的整数数组 nums ，该数组由 互不相同 的数字组成。另给你两个整数 start 和 goal 。
整数 x 的值最开始设为 start ，你打算执行一些运算使 x 转化为 goal 。你可以对数字 x 重复执行下述运算：
如果 0 <= x <= 1000 ，那么，对于数组中的任一下标 i（0 <= i < nums.length），可以将 x 设为下述任一值：
x + nums[i]
x - nums[i]
x ^ nums[i]（按位异或 XOR）
注意，你可以按任意顺序使用每个 nums[i] 任意次。使 x 越过 0 <= x <= 1000 范围的运算同样可以生效，但该该运算执行后将不能执行其他运算。
返回将 x = start 转化为 goal 的最小操作数；如果无法完成转化，则返回 -1 。

BFS。
 */