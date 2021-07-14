import java.util.HashMap;
import java.util.Map;

public class Solution657 {
    public boolean judgeCircle(String moves) {
        Map<Character, Integer> map = new HashMap<>(4);
        for (char ch : moves.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map.getOrDefault('U', 0).equals(map.getOrDefault('D', 0))
                && map.getOrDefault('L', 0).equals(map.getOrDefault('R', 0));
    }
}
/*
657. 机器人能否返回原点
https://leetcode-cn.com/problems/robot-return-to-origin/

统计字符次数。若 U == D 并且 L == R 即能返回原点
 */