import java.math.BigInteger;

public class Solution2117 {
    public String abbreviateProduct(int left, int right) {
        // BigInteger 乘积
        BigInteger product = new BigInteger("1");
        for (int i = left; i <= right; i++) {
            BigInteger cur = new BigInteger(i + "");
            product = product.multiply(cur);
        }
        String productStr = product.toString();
        int len = productStr.length();
        int C = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (productStr.charAt(i) == '0') {
                C++;
            } else {
                break;
            }
        }
        if (len - C > 10) {
            String pre = productStr.substring(0, 5);
            String suf = productStr.substring(len - C - 5, len - C);
            return pre + "..." + suf + "e" + C;
        }
        return productStr.substring(0, len - C) + "e" + C;
    }
}
/*
2117. 一个区间内所有数乘积的缩写
https://leetcode-cn.com/problems/abbreviating-the-product-of-a-range/

第 68 场双周赛 T4。

给你两个正整数 left 和 right ，满足 left <= right 。请你计算 闭区间 [left, right] 中所有整数的 乘积 。
由于乘积可能非常大，你需要将它按照以下步骤 缩写 ：
统计乘积中 后缀 0 的数目，将这个数目记为 C 。
1.比方说，1000 中有 3 个后缀 0 ，546 中没有后缀 0 。
将乘积中剩余数字记为 d 。如果 d > 10 ，那么将乘积表示为 <pre>...<suf> 的形式，
其中 <pre> 表示乘积最 开始 的 5 个数位，<suf> 表示删除后缀 0 之后 结尾的 5 个数位。如果 d <= 10 ，我们不对它做修改。
2.比方说，我们将 1234567654321 表示为 12345...54321 ，但是 1234567 仍然表示为 1234567 。
最后，将乘积表示为 字符串 "<pre>...<suf>eC" 。
3.比方说，12345678987600000 被表示为 "12345...89876e5" 。
请你返回一个字符串，表示 闭区间 [left, right] 中所有整数 乘积 的 缩写 。
提示：
1 <= left <= right <= 10^6

高赞题解: 一个数据团灭绝大部分代码(包括标程)：误差分析的一些知识，以及polylog n的做法
https://leetcode-cn.com/problems/abbreviating-the-product-of-a-range/solution/yi-ge-shu-ju-tuan-mie-jue-da-bu-fen-dai-234yd/
 */