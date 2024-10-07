import java.util.HashMap;
import java.util.Map;

public class SolutionLCR120 {
    public int findRepeatDocument(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int v : nums) {
            if (cntMap.merge(v, 1, Integer::sum) > 1) {
                return v;
            }
        }
        return -1;
    }
}
/*
LCR 120. 寻找文件副本
https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/description/

设备中存有 n 个文件，文件 id 记于数组 documents。若文件 id 相同，则定义为该文件存在副本。请返回任一存在副本的文件 id。
提示：
0 ≤ documents[i] ≤ n-1
2 <= n <= 100000
 */