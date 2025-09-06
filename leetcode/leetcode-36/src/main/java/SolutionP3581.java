public class SolutionP3581 {
    private static final String[] MP = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public int countOddLetters(int n) {
        int xor = 0;
        while (n > 0) {
            int digit = n % 10;
            for (char c : MP[digit].toCharArray()) xor ^= 1 << (c - 'a');
            n /= 10;
        }
        return Integer.bitCount(xor);
    }
}
/*
$3581. 计算数字中的奇数字母数量
https://leetcode.cn/problems/count-odd-letters-from-number/description/

你被给定一个整数 n，执行以下步骤：
- 将 n 的每个数位转换为它的小写英文单词（例如 4 → "four", 1 → "one"）。
- 将那些单词按照 原始数字顺序 连接 起来形成一个字符串 s。
返回字符串 s 中出现 奇数 次的 不同 字符的数量。
提示：
1 <= n <= 10^9

模拟。
时间复杂度: O(logn)
 */