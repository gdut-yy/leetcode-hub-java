import java.util.ArrayList;
import java.util.List;

public class Solution89 {
    public List<Integer> grayCode(int n) {
        List<Integer> resList = new ArrayList<>();
        for (int state = 0; state < (1 << n); state++) {
            resList.add((state >> 1) ^ state);
        }
        return resList;
    }
}
/*
89. 格雷编码
https://leetcode.cn/problems/gray-code/

n 位格雷码序列 是一个由 2n 个整数组成的序列，其中：
- 每个整数都在范围 [0, 2n - 1] 内（含 0 和 2n - 1）
- 第一个整数是 0
- 一个整数在序列中出现 不超过一次
- 每对 相邻 整数的二进制表示 恰好一位不同 ，且
- 第一个 和 最后一个 整数的二进制表示 恰好一位不同
给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
提示：
1 <= n <= 16

位运算
 */