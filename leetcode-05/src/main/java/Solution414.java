import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution414 {
    public int thirdMax(int[] nums) {
        Set<Integer> hashSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.addAll(hashSet);
        if (priorityQueue.size() < 3) {
            return priorityQueue.element();
        } else {
            priorityQueue.remove();
            priorityQueue.remove();
            return priorityQueue.remove();
        }
    }
}
/*
414. 第三大的数
https://leetcode.cn/problems/third-maximum-number/

给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 */