import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution1738 {
    public int kthLargestValue(int[][] matrix, int k) {
        int matrixM = matrix.length;
        int matrixN = matrix[0].length;
        int[][] pre = new int[matrixM + 1][matrixN + 1];
        List<Integer> results = new ArrayList<>();
        for (int i = 1; i <= matrixM; ++i) {
            for (int j = 1; j <= matrixN; ++j) {
                pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                results.add(pre[i][j]);
            }
        }

        nthElement(results, 0, k - 1, results.size() - 1);
        return results.get(k - 1);
    }

    public void nthElement(List<Integer> results, int left, int kth, int right) {
        if (left == right) {
            return;
        }
        int pivot = (int) (left + Math.random() * (right - left + 1));
        swap(results, pivot, right);
        // 三路划分（three-way partition）
        int sepl = left - 1, sepr = left - 1;
        for (int i = left; i <= right; i++) {
            if (results.get(i) > results.get(right)) {
                swap(results, ++sepr, i);
                swap(results, ++sepl, sepr);
            } else if (Objects.equals(results.get(i), results.get(right))) {
                swap(results, ++sepr, i);
            }
        }
        if (sepl >= left + kth || left + kth > sepr) {
            if (left + kth <= sepl) {
                nthElement(results, left, kth, sepl);
            } else {
                nthElement(results, sepr + 1, kth - (sepr - left + 1), right);
            }
        }
    }

    public void swap(List<Integer> results, int index1, int index2) {
        int temp = results.get(index1);
        results.set(index1, results.get(index2));
        results.set(index2, temp);
    }
}
/*
1738. 找出第 K 大的异或坐标值
https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/

二维前缀和 + 快速选择算法

时间复杂度 O(mn)。
空间复杂度 O(mn)。
 */