import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionLCR170 {
    public int reversePairs(int[] record) {
        int n = record.length;
        // 离散化
        int[] yArr = getDiscrete(record);

        int res = 0;
        BIT tr = new BIT(yArr.length);
        for (int i = n - 1; i >= 0; i--) {
            int yId = getId(yArr, record[i]);
            tr.add(yId, 1);
            res += tr.query(yId - 1);
        }
        return res;
    }

    private int[] getDiscrete(int[] xArr) {
        Set<Integer> set = new HashSet<>();
        for (int x : xArr) {
            set.add(x);
        }
        int sz = set.size();
        int[] yArr = new int[sz];
        int id = 0;
        for (Integer x : set) {
            yArr[id++] = x;
        }
        Arrays.sort(yArr);
        return yArr;
    }

    private int getId(int[] yArr, int x) {
        return Arrays.binarySearch(yArr, x) + 1;
    }

    static class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        int lb(int x) {
            return x & -x;
        }

        void add(int pos, int val) {
            for (; pos <= n; pos += lb(pos)) tree[pos] += val;
        }

        int query(int pos) {
            int ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
            return ret;
        }
    }
}
/*
LCR 170. 交易逆序对的总数
https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/

在股票交易中，如果前一天的股价高于后一天的股价，则可以认为存在一个「交易逆序对」。请设计一个程序，输入一段时间内的股票交易记录 record，返回其中存在的「交易逆序对」总数。
限制：
0 <= record.length <= 50000

离散化树状数组。注意本题没有给出 nums[i] 的范围，有可能存在负数，因此需要用到离散化。
时间复杂度 O(nlogn)
空间复杂度 O(n)
相似题目: 315. 计算右侧小于当前元素的个数
https://leetcode.cn/problems/count-of-smaller-numbers-after-self/
 */