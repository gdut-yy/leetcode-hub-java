import java.util.HashSet;
import java.util.Set;

public class SolutionLCR186 {
    public boolean checkDynasty(int[] places) {
        Set<Integer> hashSet = new HashSet<>();
        // [0,13]
        int min = 14;
        int max = -1;
        int cnt0 = 0;
        for (int v : places) {
            if (v > 0) {
                min = Math.min(min, v);
                max = Math.max(max, v);
                hashSet.add(v);
            } else {
                cnt0++;
            }
        }
        // 不可构成顺子
        // 最大值 - 最小值 >= 5（除去大小王）
        // 存在重复的牌（除去大小王）
        return (max - min < 5) && hashSet.size() + cnt0 == 5;
    }
}
/*
LCR 186. 文物朝代判断
https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/

展览馆展出来自 13 个朝代的文物，每排展柜展出 5 个文物。某排文物的摆放情况记录于数组 places，其中 places[i] 表示处于第 i 位文物的所属朝代编号。其中，编号为 0 的朝代表示未知朝代。请判断并返回这排文物的所属朝代编号是否能够视为连续的五个朝代（如遇未知朝代可算作连续情况）。
提示：
places.length = 5
0 <= places[i] <= 13

除去大小王的前提下，以下两种情况不可构成顺子：
1.最大值 - 最小值 >= 5
2.存在重复的牌
 */