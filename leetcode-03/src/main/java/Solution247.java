import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution247 {
    public List<String> findStrobogrammatic(int n) {
        if (n == 1) {
            return List.of("0", "1", "8");
        } else if (n == 2) {
            return List.of("11", "69", "88", "96");
        } else {
            Map<Integer, List<String>> hashMap = new HashMap<>();
            hashMap.put(0, List.of());
            hashMap.put(1, List.of("0", "1", "8"));
            hashMap.put(2, List.of("00", "11", "69", "88", "96"));
            for (int i = 3; i <= n; i++) {
                // n-2
                List<String> lastList = hashMap.get(i - 2);
                List<String> curList = new ArrayList<>();
                for (String middleStr : lastList) {
                    if (i != n - 1) {
                        curList.add("0" + middleStr + "0");
                    }
                    curList.add("1" + middleStr + "1");
                    curList.add("8" + middleStr + "8");
                    curList.add("6" + middleStr + "9");
                    curList.add("9" + middleStr + "6");
                }
                hashMap.put(i, curList);
            }
            return hashMap.get(n);
        }
    }
}
/*
$247. 中心对称数 II
https://leetcode-cn.com/problems/strobogrammatic-number-ii/

中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
找到所有长度为 n 的中心对称数。
 */