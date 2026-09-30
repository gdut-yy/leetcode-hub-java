import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Solution757 {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        // 栈中保存闭区间左右端点，栈底到栈顶的区间长度的和
        List<int[]> st = new ArrayList<>();
        st.add(new int[]{-2, -2, 0}); // 哨兵，保证不和任何区间相交
        for (int[] t : intervals) {
            int start = t[0], end = t[1];
            int i = sortSearch(st.size(), (m) -> st.get(m)[0] >= start) - 1;
            int[] e = st.get(i);
            int d = 2 - (st.get(st.size() - 1)[2] - e[2]); // 去掉运行中的时间点
            if (start <= e[1]) { // start 在区间 st[i] 内
                d -= e[1] - start + 1; // 去掉运行中的时间点
            }
            if (d <= 0) {
                continue;
            }
            while (end - st.get(st.size() - 1)[1] <= d) { // 剩余的 d 填充区间后缀
                e = st.remove(st.size() - 1);
                d += e[1] - e[0] + 1; // 合并区间
            }
            st.add(new int[]{end - d + 1, end, st.get(st.size() - 1)[2] + d});
        }
        return st.get(st.size() - 1)[2];
    }

    private int sortSearch(int n, Function<Integer, Boolean> f) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
/*
757. 设置交集大小至少为2
https://leetcode.cn/problems/set-intersection-size-at-least-two/description/

给你一个二维整数数组 intervals ，其中 intervals[i] = [starti, endi] 表示从 starti 到 endi 的所有整数，包括 starti 和 endi 。
包含集合 是一个名为 nums 的数组，并满足 intervals 中的每个区间都 至少 有 两个 整数在 nums 中。
例如，如果 intervals = [[1,3], [3,7], [8,9]] ，那么 [1,2,4,7,8,9] 和 [2,3,4,8,9] 都符合 包含集合 的定义。
返回包含集合可能的最小大小。
示例 1：
输入：intervals = [[1,3],[3,7],[8,9]]
输出：5
解释：nums = [2, 3, 4, 8, 9].
可以证明不存在元素数量为 4 的包含集合。
示例 2：
输入：intervals = [[1,3],[1,4],[2,5],[3,5]]
输出：3
解释：nums = [2, 3, 4].
可以证明不存在元素数量为 2 的包含集合。
示例 3：
输入：intervals = [[1,2],[2,3],[2,4],[4,5]]
输出：5
解释：nums = [1, 2, 3, 4, 5].
可以证明不存在元素数量为 4 的包含集合。
提示：
1 <= intervals.length <= 3000
intervals[i].length == 2
0 <= starti < endi <= 10^8

栈+二分查找
https://leetcode.cn/problems/set-intersection-size-at-least-two/solutions/3836878/tong-yong-jie-fa-zhan-er-fen-cha-zhao-py-i542/
 */