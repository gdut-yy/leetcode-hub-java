import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution752 {
    /**
     * 打开转盘锁
     *
     * @param deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
     * @param target   代表可以解锁的数字
     * @return 给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
     */
    public int openLock(String[] deadends, String target) {
        // 记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        // 记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        // 从起点开始启动广度优先搜索
        int step = 0;
        queue.add("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.remove();
                if (deads.contains(cur)) {
                    continue;
                }
                // 判断是否到终点
                if (target.equals(cur)) {
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        queue.add(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        queue.add(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    /**
     * + 1 场景 9->0 0->1
     */
    private String plusOne(String str, int index) {
        char[] ch = str.toCharArray();
        if (ch[index] == '9') {
            ch[index] = '0';
        } else {
            ch[index] += 1;
        }
        return new String(ch);
    }

    /**
     * - 1 场景 1->0 0->9
     */
    private String minusOne(String str, int index) {
        char[] ch = str.toCharArray();
        if (ch[index] == '0') {
            ch[index] = '9';
        } else {
            ch[index] -= 1;
        }
        return new String(ch);
    }
}
/*
752. 打开转盘锁
https://leetcode-cn.com/problems/open-the-lock/

广度优先搜索。
 */