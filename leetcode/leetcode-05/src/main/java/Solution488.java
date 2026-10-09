import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution488 {
    Map<String, Integer> dp = new HashMap<>();

    public int findMinStep(String board, String hand) {
        char[] arr = hand.toCharArray();
        Arrays.sort(arr);
        hand = new String(arr);
        int ans = dfs(board, hand);
        return ans <= 5 ? ans : -1;
    }

    private int dfs(String board, String hand) {
        if (board.isEmpty()) {
            return 0;
        }
        String key = board + " " + hand;
        if (!dp.containsKey(key)) {
            int res = 6;
            for (int j = 0; j < hand.length(); ++j) {
                // 第 1 个剪枝条件: 当前球的颜色和上一个球的颜色相同
                if (j > 0 && hand.charAt(j) == hand.charAt(j - 1)) {
                    continue;
                }
                for (int i = 0; i <= board.length(); ++i) {
                    // 第 2 个剪枝条件: 只在连续相同颜色的球的开头位置插入新球
                    if (i > 0 && board.charAt(i - 1) == hand.charAt(j)) {
                        continue;
                    }
                    // 第 3 个剪枝条件: 只在以下两种情况放置新球
                    boolean choose = i < board.length() && board.charAt(i) == hand.charAt(j);
                    //  - 第 1 种情况 : 当前球颜色与后面的球的颜色相同
                    //  - 第 2 种情况 : 当前后颜色相同且与当前颜色不同时候放置球
                    if (i > 0 && i < board.length() && board.charAt(i - 1) == board.charAt(i) && board.charAt(i - 1) != hand.charAt(j)) {
                        choose = true;
                    }
                    if (choose) {
                        String newBoard = clean(board.substring(0, i) + hand.charAt(j) + board.substring(i));
                        String newHand = hand.substring(0, j) + hand.substring(j + 1);
                        res = Math.min(res, dfs(newBoard, newHand) + 1);
                    }
                }
            }
            dp.put(key, res);
        }
        return dp.get(key);
    }

    private String clean(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> letterStack = new ArrayDeque<>();
        Deque<Integer> countStack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            while (!letterStack.isEmpty() && c != letterStack.peek() && countStack.peek() >= 3) {
                letterStack.pop();
                countStack.pop();
            }
            if (letterStack.isEmpty() || c != letterStack.peek()) {
                letterStack.push(c);
                countStack.push(1);
            } else {
                countStack.push(countStack.pop() + 1);
            }
        }
        if (!countStack.isEmpty() && countStack.peek() >= 3) {
            letterStack.pop();
            countStack.pop();
        }
        while (!letterStack.isEmpty()) {
            char letter = letterStack.pop();
            int count = countStack.pop();
            sb.append(String.valueOf(letter).repeat(Math.max(0, count)));
        }
        sb.reverse();
        return sb.toString();
    }
}
/*
488. 祖玛游戏
https://leetcode.cn/problems/zuma-game/description/

你正在参与祖玛游戏的一个变种。
在这个祖玛游戏变体中，桌面上有 一排 彩球，每个球的颜色可能是：红色 'R'、黄色 'Y'、蓝色 'B'、绿色 'G' 或白色 'W' 。你的手中也有一些彩球。
你的目标是 清空 桌面上所有的球。每一回合：
- 从你手上的彩球中选出 任意一颗 ，然后将其插入桌面上那一排球中：两球之间或这一排球的任一端。
- 接着，如果有出现 三个或者三个以上 且 颜色相同 的球相连的话，就把它们移除掉。
  - 如果这种移除操作同样导致出现三个或者三个以上且颜色相同的球相连，则可以继续移除这些球，直到不再满足移除条件。
- 如果桌面上所有球都被移除，则认为你赢得本场游戏。
- 重复这个过程，直到你赢了游戏或者手中没有更多的球。
给你一个字符串 board ，表示桌面上最开始的那排球。另给你一个字符串 hand ，表示手里的彩球。请你按上述操作步骤移除掉桌上所有球，计算并返回所需的 最少 球数。如果不能移除桌上所有的球，返回 -1 。
示例 1：
输入：board = "WRRBBW", hand = "RB"
输出：-1
解释：无法移除桌面上的所有球。可以得到的最好局面是：
- 插入一个 'R' ，使桌面变为 WRRRBBW 。WRRRBBW -> WBBW
- 插入一个 'B' ，使桌面变为 WBBBW 。WBBBW -> WW
桌面上还剩着球，没有其他球可以插入。
示例 2：
输入：board = "WWRRBBWW", hand = "WRBRW"
输出：2
解释：要想清空桌面上的球，可以按下述步骤：
- 插入一个 'R' ，使桌面变为 WWRRRBBWW 。WWRRRBBWW -> WWBBWW
- 插入一个 'B' ，使桌面变为 WWBBBWW 。WWBBBWW -> WWWW -> empty
只需从手中出 2 个球就可以清空桌面。
示例 3：
输入：board = "G", hand = "GGGGG"
输出：2
解释：要想清空桌面上的球，可以按下述步骤：
- 插入一个 'G' ，使桌面变为 GG 。
- 插入一个 'G' ，使桌面变为 GGG 。GGG -> empty
只需从手中出 2 个球就可以清空桌面。
示例 4：
输入：board = "RBYYBBRRB", hand = "YRBGB"
输出：3
解释：要想清空桌面上的球，可以按下述步骤：
- 插入一个 'Y' ，使桌面变为 RBYYYBBRRB 。RBYYYBBRRB -> RBBBRRB -> RRRB -> B
- 插入一个 'B' ，使桌面变为 BB 。
- 插入一个 'B' ，使桌面变为 BBB 。BBB -> empty
只需从手中出 3 个球就可以清空桌面。
提示：
1 <= board.length <= 16
1 <= hand.length <= 5
board 和 hand 由字符 'R'、'Y'、'B'、'G' 和 'W' 组成
桌面上一开始的球中，不会有三个及三个以上颜色相同且连着的球
 */