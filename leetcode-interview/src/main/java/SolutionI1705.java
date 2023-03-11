import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionI1705 {
    public String[] findLongestSubarray(String[] array) {
        int n = array.length;

        int sum = 0;
        int maxLen = 0, maxStart = 0;
        // 首次出现下标
        Map<Integer, Integer> sumFirstMap = new HashMap<>();
        sumFirstMap.put(0, -1);
        for (int j = 0; j < n; j++) {
            sum += Character.isDigit(array[j].charAt(0)) ? 1 : -1;

            if (sumFirstMap.containsKey(sum)) {
                int i = sumFirstMap.get(sum);
                if (maxLen < j - i) {
                    maxLen = j - i;
                    maxStart = i + 1;
                }
            } else {
                sumFirstMap.put(sum, j);
            }
        }

        return Arrays.copyOfRange(array, maxStart, maxStart + maxLen);
    }
}
/*
面试题 17.05. 字母与数字
https://leetcode.cn/problems/find-longest-subarray-lcci/

给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。
返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
示例 1:
输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
示例 2:
输入: ["A","A"]
输出: []
提示：
array.length <= 100000

前置和。
把数字/字母 看成 1/-1，问题转化为求区间和等于 0 的最大长度
相似题目: 1124. 表现良好的最长时间段
https://leetcode.cn/problems/longest-well-performing-interval/
1371. 每个元音包含偶数次的最长子字符串
https://leetcode.cn/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 */