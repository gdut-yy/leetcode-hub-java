public class Solution900 {
    static class RLEIterator {
        int[] a;
        int i, q;

        public RLEIterator(int[] encoding) {
            this.a = encoding;
            i = q = 0;
        }

        public int next(int n) {
            while (i < a.length) {
                if (q + n > a[i]) {
                    n -= a[i] - q;
                    q = 0;
                    i += 2;
                } else {
                    q += n;
                    return a[i + 1];
                }
            }
            return -1;
        }
    }
}
/*
900. RLE 迭代器
https://leetcode.cn/problems/rle-iterator/description/

我们可以使用游程编码(即 RLE )来编码一个整数序列。在偶数长度 encoding ( 从 0 开始 )的游程编码数组中，对于所有偶数 i ，encoding[i] 告诉我们非负整数 encoding[i + 1] 在序列中重复的次数。
- 例如，序列 arr = [8,8,8,5,5] 可以被编码为 encoding =[3,8,2,5] 。encoding =[3,8,0,9,2,5] 和 encoding =[2,8,1,8,2,5] 也是 arr 有效的 RLE 。
给定一个游程长度的编码数组，设计一个迭代器来遍历它。
实现 RLEIterator 类:
- RLEIterator(int[] encoded) 用编码后的数组初始化对象。
- int next(int n) 以这种方式耗尽后 n 个元素并返回最后一个耗尽的元素。如果没有剩余的元素要耗尽，则返回 -1 。
提示：
2 <= encoding.length <= 1000
encoding.length 为偶
0 <= encoding[i] <= 10^9
1 <= n <= 10^9
每个测试用例调用next 不高于 1000 次

维护下一个元素的位置和删除次数
时间复杂度：O(N+Q)，其中 N 是数组 A 的长度，Q 是调用函数 next() 的次数。
 */