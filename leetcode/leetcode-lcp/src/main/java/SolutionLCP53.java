import java.util.Arrays;

public class SolutionLCP53 {
    public int defendSpaceCity(int[] time, int[] position) {
        int len = time.length;

        int maxPost = Arrays.stream(position).max().orElseThrow();
        int maskMax = 1 << Arrays.stream(time).max().orElseThrow();

        int[] rain = new int[maxPost + 1];
        for (int i = 0; i < len; i++) {
            rain[position[i]] |= 1 << (time[i] - 1);
        }

        int[] union = new int[maskMax];
        int[] single = new int[maskMax];
        for (int i = 1; i < maskMax; i++) {
            int lowbit1 = i & -i;
            int j = i ^ lowbit1;
            int lowbit2 = j & -j;
            // lb == (lb2 >> 1) 表示两个时间点相邻
            union[i] = union[j] + (lowbit1 == (lowbit2 >> 1) ? 1 : 3);
            // 递推
            single[i] = single[j] + (lowbit1 == (lowbit2 >> 1) ? 1 : 2);
        }

        // f[i][j] 表示考虑前 i 个舱室，且第 i 个舱室与第 i+1 个舱室开启联合屏障的时间点集合为 j 时，所需的最小能量
        int[][] f = new int[maxPost + 1][maskMax];
        for (int j = 0; j < maskMax; j++) {
            f[0][j] = union[j] + single[((maskMax - 1) ^ j) & rain[0]];
        }
        for (int i = 1; i <= maxPost; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE / 2);
            for (int j = 0; j < maskMax; j++) {
                // 枚举 j 的补集 mask 中的子集 pre
                for (int mask = (maskMax - 1) ^ j, pre = mask; ; pre = (pre - 1) & mask) {
                    int cost = f[i - 1][pre] + union[j] + single[(mask ^ pre) & rain[i]];
                    f[i][j] = Math.min(f[i][j], cost);
                    if (pre == 0) {
                        break;
                    }
                }
            }
        }
        return f[maxPost][0];
    }
}
/*
LCP 53. 守护太空城
https://leetcode.cn/problems/EJvmW4/

LCCUP 力扣杯 2022 春季编程大赛个人赛 T4。

各位勇者请注意，力扣太空城发布陨石雨红色预警。
太空城中的一些舱室将要受到陨石雨的冲击，这些舱室按照编号 0 ~ N 的顺序依次排列。为了阻挡陨石损毁舱室，太空城可以使用能量展开防护屏障，具体消耗如下：
- 选择一个舱室开启屏障，能量消耗为 2
- 选择相邻两个舱室开启联合屏障，能量消耗为 3
- 对于已开启的一个屏障，多维持一时刻，能量消耗为 1
已知陨石雨的影响范围和到达时刻，time[i] 和 position[i] 分别表示该陨石的到达时刻和冲击位置。请返回太空舱能够守护所有舱室所需要的最少能量。
注意：
- 同一时间，一个舱室不能被多个屏障覆盖
- 陨石雨仅在到达时刻对冲击位置处的舱室有影响
提示：
1 <= time.length == position.length <= 500
1 <= time[i] <= 5
0 <= position[i] <= 100

O(n*3^m) 子集状压 DP + 贪心预处理 https://leetcode.cn/problems/EJvmW4/solution/by-endlesscheng-pk2q/
 */