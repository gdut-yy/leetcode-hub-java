import java.util.ArrayList;
import java.util.List;

public class Solution1947 {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int studentsM = students.length;
        int studentsN = students[0].length;
        // 兼容性评分数组 笛卡尔积
        int[][] compatibilitySumArray = new int[studentsM][studentsM];
        // 可用的 m n 坐标范围（初始值均为 0 ~ studentsN-1）
        List<Integer> availableM = new ArrayList<>();
        List<Integer> availableN = new ArrayList<>();
        for (int i = 0; i < studentsM; i++) {
            for (int j = 0; j < studentsM; j++) {
                compatibilitySumArray[i][j] = compatibilitySum(students[i], mentors[j]);
            }
            availableM.add(i);
            availableN.add(i);
        }
        return dfs(compatibilitySumArray, availableM, availableN, studentsN, 0);
    }

    /**
     * dfs
     *
     * @param compatibilitySumArray 兼容性评分数组
     * @param availableMList        可用的 m 坐标取值范围
     * @param availableNList        可用的 n 坐标取值范围
     * @param expected              当前期望的最大值
     * @param ans                   当前兼容性评分和
     * @return 最大兼容性评分和
     */
    private int dfs(int[][] compatibilitySumArray, List<Integer> availableMList, List<Integer> availableNList, int expected, int ans) {
        if (availableMList.size() == 0) {
            return ans;
        }
        if (availableMList.size() == 1) {
            return ans + compatibilitySumArray[availableMList.get(0)][availableNList.get(0)];
        }
        // 实际匹配的 m n 坐标，可能存在多个
        List<Integer> actualMList = new ArrayList<>();
        List<Integer> actualNList = new ArrayList<>();
        for (int idxM : availableMList) {
            for (int idxN : availableNList) {
                if (compatibilitySumArray[idxM][idxN] == expected) {
                    actualMList.add(idxM);
                    actualNList.add(idxN);
                }
            }
        }
        if (actualMList.size() == 0) {
            // 找不到就降低期望
            return dfs(compatibilitySumArray, availableMList, availableNList, expected - 1, ans);
        } else {
            // 若有存在多个匹配的坐标，找最大的
            int maxSum = -1;
            for (int i = 0; i < actualMList.size(); i++) {
                Integer actualM = actualMList.get(i);
                Integer actualN = actualNList.get(i);
                // 可用坐标范围剪枝 注意要新 copy 一个 List 副本
                List<Integer> copyAvailableM = new ArrayList<>(List.copyOf(availableMList));
                List<Integer> copyAvailableN = new ArrayList<>(List.copyOf(availableNList));
                copyAvailableM.remove(actualM);
                copyAvailableN.remove(actualN);
                maxSum = Math.max(maxSum, dfs(compatibilitySumArray, copyAvailableM, copyAvailableN, expected, ans + expected));
            }
            return maxSum;
        }
    }

    /**
     * 两个数组兼容和
     */
    private int compatibilitySum(int[] arr1, int[] arr2) {
        int cnt = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
1947. 最大兼容性评分和
https://leetcode-cn.com/problems/maximum-compatibility-score-sum/

第 251 场周赛 T3。
二分图最大权匹配
匈牙利算法 KM 算法 https://oi-wiki.org/graph/graph-matching/bigraph-weight-match/
 */