import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2007 {
    public int[] findOriginalArray(int[] changed) {
        int len = changed.length;
        if (len % 2 == 1) {
            return new int[]{};
        }
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int change : changed) {
            cntMap.put(change, cntMap.getOrDefault(change, 0) + 1);
        }
        Arrays.sort(changed);
        List<Integer> resList = new ArrayList<>();
        for (int i = len - 1; i >= 0; i--) {
            if (changed[i] % 2 == 0) {
                int key = changed[i] / 2;
                if (cntMap.containsKey(key) && cntMap.containsKey(changed[i])) {
                    resList.add(key);
                    int value = cntMap.get(key);
                    if (value == 1) {
                        cntMap.remove(key);
                    } else {
                        cntMap.put(key, value - 1);
                    }
                    if (cntMap.containsKey(changed[i])) {
                        int value2 = cntMap.get(changed[i]);
                        if (value2 == 1) {
                            cntMap.remove(changed[i]);
                        } else {
                            cntMap.put(changed[i], value2 - 1);
                        }
                    }
                }
            }
        }
        if (resList.size() != len / 2 || cntMap.size() != 0) {
            return new int[]{};
        }
        return resList.stream().mapToInt(i -> i).toArray();
    }
}
/*
2007. 从双倍数组中还原原数组
https://leetcode-cn.com/problems/find-original-array-from-doubled-array/

第 61 场双周赛 T2。
changed.length 为奇数时无解。
如果能从双倍数组中还原原数组，则可以排序后，按降序找还原数组，HashMap 判断当前所需数值是否仍可用。

时间复杂度 O(nlogn) 即排序时间复杂度
 */