public class SolutionLCR190 {
    public int encryptionCalculate(int dataA, int dataB) {
        // 当进位为 0 时跳出
        while (dataB != 0) {
            // c = 进位
            int c = (dataA & dataB) << 1;
            // a = 非进位和
            dataA ^= dataB;
            // b = 进位
            dataB = c;
        }
        return dataA;
    }

    public int encryptionCalculate2(int a, int b) {
        return a + b;
    }
}
/*
LCR 190. 加密运算
https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/

计算机安全专家正在开发一款高度安全的加密通信软件，需要在进行数据传输时对数据进行加密和解密操作。假定 dataA 和 dataB 分别为随机抽样的两次通信的数据量：
- 正数为发送量
- 负数为接受量
- 0 为数据遗失
请不使用四则运算符的情况下实现一个函数计算两次通信的数据量之和（三种情况均需被统计），以确保在数据传输过程中的高安全性和保密性。
提示：
dataA 和 dataB 均可能是负数或 0
结果不会溢出 32 位整数

官方题解: https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/mian-shi-ti-65-bu-yong-jia-jian-cheng-chu-zuo-ji-7/
 */