import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution893 {
    public int numSpecialEquivGroups(String[] words) {
        List<int[][]> oddEvenList = new ArrayList<>();
        for (String word : words) {
            int[][] oddEven = new int[2][26];
            oddEven[0] = getCnt(word, false);
            oddEven[1] = getCnt(word, true);
            // 去重，类似 Set
            if (!listContainTarget(oddEvenList, oddEven)) {
                oddEvenList.add(oddEven);
            }
        }
        return oddEvenList.size();
    }

    private boolean listContainTarget(List<int[][]> list, int[][] target) {
        for (int[][] cur : list) {
            if (Arrays.deepEquals(cur, target)) {
                return true;
            }
        }
        return false;
    }

    private int[] getCnt(String str, boolean isOdd) {
        int[] oddCnt = new int[26];
        int i = isOdd ? 1 : 0;
        for (; i < str.length(); i += 2) {
            oddCnt[str.charAt(i) - 'a']++;
        }
        return oddCnt;
    }
}
/*
893. 特殊等价字符串组
https://leetcode-cn.com/problems/groups-of-special-equivalent-strings/

经过任意次交换字符串 s 任意两个偶数下标的字符或任意两个奇数下标的字符，使字符串 s 与字符串 t 相等，s 与 t 即是特殊等价字符串
由此易得出，统计两个字符串偶数下标字符频次与奇数下标字符频次，如果相等，即为特殊等价字符串

如 abcd 被记为 [[1,0,1,0,...,0],
               [0,1,0,1,...,0]]
   cdab 被记为 [[1,0,1,0,...,0],
               [0,1,0,1,...,0]]
而 zzyx 被记为 [[0,...,0,0,1,1],
               [0,...,0,1,0,1]]

然后去重统计个数即可。
 */