import java.util.HashMap;
import java.util.Map;

public class Hust10242023T1 {
    public boolean perfectPerformance(String moves) {
        // 模拟
        Map<Character, Integer> map = new HashMap<>(4);
        for (char ch : moves.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map.getOrDefault('U', 0).equals(map.getOrDefault('D', 0))
                && map.getOrDefault('L', 0).equals(map.getOrDefault('R', 0));
    }
}
/*
Q1. 完美表演
https://leetcode.cn/contest/hust_1024_2023/problems/zActK3/

在二维平面上，有一个运动员从原点 (0, 0) 开始。给出他的表演动作，判断运动员在完成表演后是否在(0, 0) 处结束。
表演动作由字符串s表示。字符 s[i] 表示其第 i 次动作。运动员的有效动作有R（右），L（左），U（上）和 D（下）。
如果运动员在完成所有动作后返回原点，则返回 true。否则，返回 false。
注意：运动员“面朝”的方向无关紧要。 "R" 将始终使运动员向右移动一次，"L" 将始终向左移动等。此外，假设每次移动运动员的移动幅度相同。
示例 1：
输入: s = "UD" 输出: true 解释：运动员向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终回到它开始的原点。因此返回 true。
示例 2：
输入: s = "LL" 输出: false 解释：运动员向左移动两次。它最终位于原点的左侧，距原点有两次 “移动” 的距离。我们返回 false，因为它在移动结束时没有返回原点。
提示：
1 <= s.length <= 2 * 10^4
s只包含字符'U','D','L'和'R'
 */