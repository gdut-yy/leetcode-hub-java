import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        // hi 降序，ki 升序 组合排序
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : -(o1[0] - o2[0]));
        // 插入队列
        List<int[]> res = new ArrayList<>();
        for (int[] peo : people) {
            res.add(peo[1], peo);
        }
        return res.toArray(new int[res.size()][]);
    }
}
/*
406. 根据身高重建队列
https://leetcode-cn.com/problems/queue-reconstruction-by-height/

第一眼以为是单调栈，实际上并不是。
将每个人按照身高从大到小进行排序，ki 升序排序
然后插入队列，高的人会挡住矮的人，但是矮的人不会挡住高的人，所以未添加到队列的人并不会对已添加进队列的人有影响。

时间复杂度 O(n^2)（组合排序 O(nlogn)，插入队列 O(n^2)）
空间复杂度 O(logn)
 */