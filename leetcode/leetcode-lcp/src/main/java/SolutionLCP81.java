public class SolutionLCP81 {
    private static int FULL;

    public int getNandResult(int k, int[] arr, int[][] operations) {
        FULL = (1 << k) - 1;
        int res = 0;
        for (int[] op : operations) {
            int type = op[0], x = op[1], y = op[2];
            if (type == 1) {
                for (int ai : arr) y = nand(y, ai);
                // 偶数次
                if ((x & 1) == 0) {
                    for (int ai : arr) y = nand(y, ai);
                }
                res ^= y;
            } else {
                arr[x] = y;
            }
        }
        return res;
    }

    private int nand(int a, int b) {
        return ~(a & b) & FULL;
    }
}
/*
LCP 81. 与非的谜题
https://leetcode.cn/problems/ryfUiz/

LCCUP'23 春季战队赛 T5。

在永恒之森中，封存着有关万灵之树线索的卷轴，只要探险队通过最后的考验，便可以获取前往万灵之树的线索。
探险队需要从一段不断变化的谜题数组中找到最终的密码，初始的谜题为长度为 n 的数组 arr（下标从 0 开始），数组中的数字代表了 k 位二进制数。
破解谜题的过程中，需要使用 与非（NAND） 运算方式，operations[i] = [type,x,y] 表示第 i 次进行的谜题操作信息：
- 若 type = 0，表示修改操作，将谜题数组中下标 x 的数字变化为 y；
- 若 type = 1，表示运算操作，将数字 y 进行 x*n 次「与非」操作，第 i 次与非操作为 y = y NAND arr[i%n]；
  > 运算操作结果即：y NAND arr[0%n] NAND arr[1%n] NAND arr[2%n] ... NAND arr[(x*n-1)%n]
最后，将所有运算操作的结果按顺序逐一进行 异或（XOR）运算，从而得到最终解开封印的密码。请返回最终解开封印的密码。
注意:
- 「与非」（NAND）的操作为：先进行 与 操作，后进行 非 操作。
  > 例如：两个三位二进制数2和3，其与非结果为 NOT ((010) AND (011)) = (101) = 5

位运算 + 打表
比赛中 30 分钟 + WA 3 发的代价拿下这道题，猜规律。
 */