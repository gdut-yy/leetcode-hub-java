public class Solution972 {
    // https://leetcode.cn/problems/equal-rational-numbers/solutions/3582/xiang-deng-de-you-li-shu-by-leetcode/
    public boolean isRationalEqual(String S, String T) {
        Fraction f1 = convert(S);
        Fraction f2 = convert(T);
        return f1.n == f2.n && f1.d == f2.d;
    }

    public Fraction convert(String S) {
        int state = 0; //whole, decimal, repeating
        Fraction ans = new Fraction(0, 1);
        int decimal_size = 0;

        for (String part : S.split("[.()]")) {
            state++;
            if (part.isEmpty()) continue;
            long x = Long.parseLong(part);
            int sz = part.length();

            if (state == 1) { // whole
                ans.iadd(new Fraction(x, 1));
            } else if (state == 2) { // decimal
                ans.iadd(new Fraction(x, (long) Math.pow(10, sz)));
                decimal_size = sz;
            } else { // repeating
                long denom = (long) Math.pow(10, decimal_size);
                denom *= (long) (Math.pow(10, sz) - 1);
                ans.iadd(new Fraction(x, denom));
            }
        }
        return ans;
    }

    static class Fraction {
        long n, d;

        Fraction(long n, long d) {
            long g = gcd(n, d);
            this.n = n / g;
            this.d = d / g;
        }

        public void iadd(Fraction other) {
            long numerator = this.n * other.d + this.d * other.n;
            long denominator = this.d * other.d;
            long g = Fraction.gcd(numerator, denominator);
            this.n = numerator / g;
            this.d = denominator / g;
        }

        static long gcd(long x, long y) {
            return x != 0 ? gcd(y % x, x) : y;
        }
    }
}
/*
972. 相等的有理数
https://leetcode.cn/problems/equal-rational-numbers/description/

给定两个字符串 s 和 t ，每个字符串代表一个非负有理数，只有当它们表示相同的数字时才返回 true 。字符串中可以使用括号来表示有理数的重复部分。
有理数 最多可以用三个部分来表示：整数部分 <IntegerPart>、小数非重复部分 <NonRepeatingPart> 和小数重复部分 <(><RepeatingPart><)>。数字可以用以下三种方法之一来表示：
- <IntegerPart>
  - 例： 0 ,12 和 123
- <IntegerPart><.><NonRepeatingPart>
  - 例： 0.5 , 1. , 2.12 和 123.0001
- <IntegerPart><.><NonRepeatingPart><(><RepeatingPart><)>
  - 例： 0.1(6) ， 1.(9)， 123.00(1212)
十进制展开的重复部分通常在一对圆括号内表示。例如：
- 1 / 6 = 0.16666666... = 0.1(6) = 0.1666(6) = 0.166(66)
示例 1：
输入：s = "0.(52)", t = "0.5(25)"
输出：true
解释：因为 "0.(52)" 代表 0.52525252...，而 "0.5(25)" 代表 0.52525252525.....，则这两个字符串表示相同的数字。
示例 2：
输入：s = "0.1666(6)", t = "0.166(66)"
输出：true
示例 3：
输入：s = "0.9(9)", t = "1."
输出：true
解释："0.9(9)" 代表 0.999999999... 永远重复，等于 1 。[有关说明，请参阅此链接]
"1." 表示数字 1，其格式正确：(IntegerPart) = "1" 且 (NonRepeatingPart) = "" 。
提示：
每个部分仅由数字组成。
整数部分 <IntegerPart> 不会以零开头。（零本身除外）
1 <= <IntegerPart>.length <= 4
0 <= <NonRepeatingPart>.length <= 4
1 <= <RepeatingPart>.length <= 4
 */