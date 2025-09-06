import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionP3450 {
    public int maxStudentsOnBench(int[][] students) {
        Map<Integer, Set<Integer>> mp = new HashMap<>();
        for (int[] p : students) {
            mp.computeIfAbsent(p[1], e -> new HashSet<>()).add(p[0]);
        }
        return mp.values().stream().mapToInt(Set::size).max().orElse(0);
    }
}
/*
$3450. 一张长椅上的最多学生
https://leetcode.cn/problems/maximum-students-on-a-single-bench/description/

给定一个包含学生数据的 2 维数组 students，其中 students[i] = [student_id, bench_id] 表示学生 student_id 正坐在长椅 bench_id 上。
返回单个长凳上坐着的不同学生的 最大 数量。如果没有学生，返回 0。
注意：一个学生在输入中可以出现在同一张长椅上多次，但每个长椅上只能计算一次。
提示：
0 <= students.length <= 100
students[i] = [student_id, bench_id]
1 <= student_id <= 100
1 <= bench_id <= 100

哈希表去重。
时间复杂度 O(n)。
 */