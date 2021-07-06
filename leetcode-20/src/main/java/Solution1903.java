import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1903 {
    public String largestOddNumber(String num) {
        String[] odds = {"1", "3", "5", "7", "9"};
        // 优先队列-大顶堆（降序排列）
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (String odd : odds) {
            priorityQueue.add(num.lastIndexOf(odd));
        }
        Integer maxIndex = priorityQueue.poll();
        return num.substring(0, maxIndex + 1);
    }
}
/*
1903. 字符串中的最大奇数
https://leetcode-cn.com/problems/largest-odd-number-in-string/

周赛签到题。从后往前找到第一个奇数的下标，截取的子字符串即为最大奇数。
 */