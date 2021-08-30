import java.math.BigInteger;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution1985 {
    public String kthLargestNumber(String[] nums, int k) {
        // 大顶堆
        PriorityQueue<String> priorityQueue = new PriorityQueue<>((o1, o2) -> new BigInteger(o2).compareTo(new BigInteger(o1)));
        Collections.addAll(priorityQueue, nums);
        String res = "";
        while (k > 0) {
            res = priorityQueue.poll();
            k--;
        }
        return res;
    }


}
/*
1985. 找出数组中的第 K 大整数
https://leetcode-cn.com/problems/find-the-kth-largest-integer-in-the-array/

第 256 场周赛 T2。
优先队列一眼题。
 */