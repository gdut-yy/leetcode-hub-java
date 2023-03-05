public class SolutionI0502 {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        for (int i = 0; i < 6; i++) {
            num *= 2;
            if (num < 1) {
                sb.append("0");
            } else {
                sb.append("1");
                num--;
                if (num == 0) {
                    return sb.toString();
                }
            }
        }
        return "ERROR";
    }
}
/*
面试题 05.02. 二进制数转字符串
https://leetcode.cn/problems/bianry-number-to-string-lcci/

二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。
示例1:
 输入：0.625
 输出："0.101"
示例2:
 输入：0.1
 输出："ERROR"
 提示：0.1无法被二进制准确表示
提示：
32位包括输出中的 "0." 这两位。
题目保证输入用例的小数位数最多只有 6 位

证明：至多循环 6 次 https://leetcode.cn/problems/bianry-number-to-string-lcci/solution/zheng-ming-zhi-duo-xun-huan-6-ci-pythonj-b6sj/
 */