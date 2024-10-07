import java.util.Arrays;
import java.util.stream.Collectors;

public class SolutionLCR164 {
    public String crackPassword(int[] password) {
        return Arrays.stream(password)
                .mapToObj(String::valueOf)
                .sorted((x, y) -> (x + y).compareTo(y + x))
                .collect(Collectors.joining());
    }
}
/*
LCR 164. 破解闯关密码
https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/

闯关游戏需要破解一组密码，闯关组给出的有关密码的线索是：
- 一个拥有密码所有元素的非负整数数组 password
- 密码是 password 中所有元素拼接后得到的最小的一个数
请编写一个程序返回这个密码。
提示:
0 < password.length <= 100
说明:
输出结果可能非常大，所以你需要返回一个字符串而不是整数
拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0

相似题目: 179. 最大数
https://leetcode.cn/problems/largest-number/
 */