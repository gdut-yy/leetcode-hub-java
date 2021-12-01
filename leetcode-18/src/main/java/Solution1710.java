import java.util.Arrays;
import java.util.Comparator;

public class Solution1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int len = boxTypes.length;
        Arrays.sort(boxTypes, Comparator.comparingInt(o -> o[1]));
        int curSize = 0;
        int res = 0;
        int idx = len - 1;
        while (idx >= 0) {
            if (curSize + boxTypes[idx][0] <= truckSize) {
                curSize += boxTypes[idx][0];
                res += boxTypes[idx][0] * boxTypes[idx][1];
                idx--;
            } else {
                break;
            }
        }
        if (idx >= 0) {
            res += (truckSize - curSize) * boxTypes[idx][1];
        }
        return res;
    }
}
/*
1710. 卡车上的最大单元数
https://leetcode-cn.com/problems/maximum-units-on-a-truck/

请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
numberOfBoxesi 是类型 i 的箱子的数量。
numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
返回卡车可以装载 单元 的 最大 总数。

贪心。
 */