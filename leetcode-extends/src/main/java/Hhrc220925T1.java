import java.util.Comparator;
import java.util.PriorityQueue;

public class Hhrc220925T1 {
    public int lastMaterial(int[] material) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int x : material) {
            priorityQueue.add(x);
        }

        while (priorityQueue.size() > 1) {
            int j = priorityQueue.remove();
            int i = priorityQueue.remove();
            priorityQueue.add(j - i);
        }
        return priorityQueue.remove();
    }
}
/*
天堂硅谷·数字经济算法编程大赛
题目-01. 化学反应
https://leetcode.cn/contest/hhrc2022/problems/o0Ma2v/

实验室内有一些化学反应物，其中的任意两种反应物之间都能发生反应，且质量的消耗量为 1:1
已知初始 material[i] 表示第 i 种反应物的质量，每次进行实验时，会选出当前 质量最大 的两种反应物进行反应，假设反应物的重量分别为 i 和 j ，且 i <= j。反应的结果如下：
- 如果 i == j，那么两种化学反应物都将被消耗完；
- 如果 i < j，那么质量为 i 的反应物将会完全消耗，而质量为 j 的反应物质量变为 j - i 。
最后，最多只会剩下一种反应物，返回此反应物的质量。如果没有反应物剩下，返回 0。
示例 1：
输入：[10,2,6,1]
输出：1
解释：
先选出 10 和 6，得到 4，数组转换为 [4,2,1]，
再选出 4 和 2，得到 2，数组转换为 [2,1]，
最后选出 2 和 1，得到 1，最终数组转换为 [1]，这就是最后剩下反应物的质量。
示例 2：
输入：[6,4,10]
输出：0
解释：
先选出 10 和 6，得到 4，所以数组转换为 [4,4]，
再选出 4 和 4，得到 0，所以数组转换为 []
因为没有反应物剩下，返回 0。
提示：
1 <= material.length <= 30
1 <= material[i] <= 1000

相似题目: 1046. 最后一块石头的重量
https://leetcode.cn/problems/last-stone-weight/
 */