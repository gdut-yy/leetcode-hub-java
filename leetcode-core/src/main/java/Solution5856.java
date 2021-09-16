import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution5856 {
    public int minSessions(int[] tasks, int sessionTime) {
        TreeMap<Integer, Integer> cntMap = new TreeMap<>(Comparator.reverseOrder());
        for (int task : tasks) {
            cntMap.put(task, cntMap.getOrDefault(task, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            int firstKey = entry.getKey();
            int firstVal = entry.getValue();
            int wantKey = sessionTime - firstKey;
            int wantVal = cntMap.getOrDefault(wantKey, 0);
            // a != b
            if (wantVal > 0 && firstKey != wantKey) {
                int minVal = Math.min(firstVal, wantVal);
                cntMap.replace(firstKey, cntMap.get(firstKey) - minVal);
                cntMap.replace(wantKey, cntMap.get(wantKey) - minVal);
                res += minVal;
            }
            // a == b
            else if (wantVal > 0) {
                int minVal = wantVal / 2;
                cntMap.replace(wantKey, cntMap.get(wantKey) - minVal * 2);
                res += minVal;
            }
        }
        // 余下的数组
        List<Integer> newList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() != 0) {
                for (int i = 0; i < entry.getValue(); i++) {
                    newList.add(entry.getKey());
                }
            }
        }
        int[] newTasks = new int[newList.size()];
        for (int i = 0; i < newTasks.length; i++) {
            newTasks[i] = newList.get(i);
        }
        return res + minSessions2(newTasks, sessionTime);
    }

    public int minSessions2(int[] tasks, int sessionTime) {
        // 降序数组
//        Arrays.sort(tasks);
        int len = tasks.length;
//        for (int i = 0; i < len / 2; i++) {
//            int tmp = tasks[i];
//            tasks[i] = tasks[len - 1 - i];
//            tasks[len - 1 - i] = tmp;
//        }
        // 贪心 + 双指针。每次取最大, 用最小去补差额
        int left = 0;
        int right = len - 1;
        int curSum = 0;
        int res = 0;
        while (left <= right) {
            if (curSum + tasks[left] <= sessionTime) {
                curSum += tasks[left];
                left++;
            } else if (curSum + tasks[right] <= sessionTime) {
                curSum += tasks[right];
                right--;
            } else {
                curSum = 0;
                res++;
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        // 2 2 1 5 1 4
//        System.out.println(new Solution5856().minSessions(new int[]{1, 2, 3}, 3));
//        System.out.println(new Solution5856().minSessions(new int[]{3, 1, 3, 1, 1}, 8));
//        System.out.println(new Solution5856().minSessions(new int[]{1, 2, 3, 4, 5}, 15));
//        System.out.println(new Solution5856().minSessions(new int[]{1, 5, 7, 10, 3, 8, 4, 2, 6, 2}, 10));
//        System.out.println(new Solution5856().minSessions(new int[]{2}, 4));
        System.out.println(new Solution5856().minSessions(new int[]{2, 3, 3, 4, 4, 4, 5, 6, 7, 10}, 12));
    }
}
/*
输入：
[1,5,7,10,3,8,4,2,6,2]
10
输出：
6
预期：
5

8,7,2,2,1


[2]
4

输入：
[2,3,3,4,4,4,5,6,7,10]
12
输出：
5
预期：
4
 */