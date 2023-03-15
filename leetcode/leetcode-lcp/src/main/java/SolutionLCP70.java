import java.util.ArrayList;
import java.util.List;

public class SolutionLCP70 {
    public int[][] sandyLandManagement(int size) {
        List<int[]> list = new ArrayList<>();
        int k = 0;
        list.add(new int[]{1, 1});
        for (int i = size; i > 1; i--) {
            if (k == 0) {
                for (int j = 1; j <= i * 2 - 1; j += 2) {
                    list.add(new int[]{i, j});
                }
            } else if (k == 1) {
                list.add(new int[]{i, 2});
            } else if (k == 2) {
                for (int j = 3; j <= i * 2 - 1; j += 2) {
                    list.add(new int[]{i, j});
                }
            } else {
                list.add(new int[]{i, 1});
            }
            k = (k + 1) % 4;
        }
        return list.toArray(int[][]::new);
    }
}
/*
LCP 70. 沙地治理
https://leetcode.cn/problems/XxZZjK/

LCCUP'22 力扣杯秋季编程大赛战队赛 T5。

在力扣城的沙漠分会场展示了一种沙柳树，这种沙柳树能够将沙地转化为坚实的绿地。
展示的区域为正三角形，这片区域可以拆分为若干个子区域，每个子区域都是边长为 1 的小三角形，其中第 i 行有 2i - 1 个小三角形。
初始情况下，区域中的所有位置都为沙地，你需要指定一些子区域种植沙柳树成为绿地，以达到转化整片区域为绿地的最终目的，规则如下：
- 若两个子区域共用一条边，则视为相邻；
如下图所示，(1,1)和(2,2)相邻，(3,2)和(3,3)相邻；(2,2)和(3,3)不相邻，因为它们没有共用边。
- 若至少有两片绿地与同一片沙地相邻，则这片沙地也会转化为绿地
- 转化为绿地的区域会影响其相邻的沙地
现要将一片边长为 size 的沙地全部转化为绿地，请找到任意一种初始指定 最少 数量子区域种植沙柳的方案，并返回所有初始种植沙柳树的绿地坐标。
提示：
1 <= size <= 1000

构造题 constructive algorithms
 */