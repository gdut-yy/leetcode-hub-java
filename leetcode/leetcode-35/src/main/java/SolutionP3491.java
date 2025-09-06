import java.util.Arrays;

public class SolutionP3491 {
    public boolean phonePrefix(String[] numbers) {
        int n = numbers.length;
        Arrays.sort(numbers);
        for (int i = 1; i < n; i++) {
            if (numbers[i].startsWith(numbers[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
/*
$3491. 电话号码前缀
https://leetcode.cn/problems/phone-number-prefix/description/

给定一个字符串数组 numbers 表示电话号码。如果没有电话号码是任何其他电话号码的前缀，则返回 true；否则，返回 false。
提示：
2 <= numbers.length <= 50
1 <= numbers[i].length <= 50
所有数字只包含 '0' 到 '9' 的数位。

排序后一定相邻。
时间复杂度 O(nlogn * L)。
 */