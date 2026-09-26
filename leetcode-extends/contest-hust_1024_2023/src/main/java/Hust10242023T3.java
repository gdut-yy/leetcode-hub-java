public class Hust10242023T3 {
    public String mathProblem(String equation) {
        int n = equation.length();
        char[] s = equation.toCharArray();
        int x = 0;
        int num = 0;

        int i = 0;
        int op = 1;
        while (i < n) {
            if (s[i] == '+') {
                op = 1;
                i++;
            } else if (s[i] == '-') {
                op = -1;
                i++;
            } else if (s[i] == '=') {
                op = 1;
                x *= -1;
                num *= -1;
                i++;
            } else {
                int j = i;
                while (j < n && s[j] != '+' && s[j] != '-' && s[j] != '=') {
                    j++;
                }
                if (s[j - 1] == 'x') {
                    x += op * (i < j - 1 ? Integer.parseInt(equation.substring(i, j - 1)) : 1);
                } else {
                    num += op * Integer.parseInt(equation.substring(i, j));
                }
                i = j;
            }
        }
        if (x == 0) {
            return num == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + -num / x;
    }
}
/*
Q3. 数学难题
https://leetcode.cn/contest/hust_1024_2023/problems/fwbmtF/

老师在黑板上写出一个字符串s表示方程，该方程仅包含变量x、其对应系数和 '+' ， '-' 操作。 假设方程中 x为 answer ，将 x 以字符串 "x=#answer"的形式返回。 题目保证，如果方程中只有一个解，则 answer的值是一个整数。 如果方程没有解或存在的解不为整数，请返回"No solution"。 如果方程有无限解，则返回 "Infinite solutions" 。
示例 1：
输入: s = "x+5-3+x=6+x-2" 输出: "x=2"
示例 2:
输入: s = "x=x" 输出: "Infinite solutions"
示例 3:
输入: s = "2x=x" 输出: "x=0"
提示:
3 <= s.length <= 1000
s仅包含 'x','+','-','='且只有一个'='
方程由绝对值在[0, 100] 范围内且无任何前导零的整数和变量 'x'组成。
 */