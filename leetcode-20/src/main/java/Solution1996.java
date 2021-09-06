import java.util.Arrays;

public class Solution1996 {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return -(o1[0] - o2[0]);
        });
        int maxDefense = properties[0][1];
        int cnt = 0;
        for (int i = 1; i < properties.length; i++) {
            if (properties[i][1] < maxDefense) {
                cnt++;
            } else {
                maxDefense = properties[i][1];
            }
        }
        return cnt;
    }
}
/*
1996. 游戏中弱角色的数量
https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game/

第 257 场周赛 T2。
1.先按照攻击从大到小排序，相同攻击的再按照防御从小到大排序。
2.遍历数组，维护遍历过的角色的防御的最大值 maxDefense。
3.对于当前角色 p，如果 p 的防御小于 maxDefense，假设其角色为 q。
由于角色按照攻击从大到小排序，假设 p 的攻击等于 q 的攻击，则 p 的防御不可能小于 maxDefense，说明 q 的攻防都大于 p，所以 p 为弱角色。
 */