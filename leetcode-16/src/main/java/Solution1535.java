public class Solution1535 {
    public int getWinner(int[] arr, int k) {
        int ans = arr[0];
        int cnt = 0;
        for (int i = 1; i < arr.length; i++) {
            if (ans < arr[i]) {
                cnt = 1;
                ans = arr[i];
            } else {
                cnt++;
            }
            // 提前退出
            if (cnt == k) {
                return ans;
            }
        }
        return ans;
    }
}
/*
1535. 找出数组游戏的赢家
https://leetcode-cn.com/problems/find-the-winner-of-an-array-game/

用 List<Integer> 根据题意进行模拟可以通过，但实际上并不需要移动数组：
arr[0] 与 arr[1] 的较大值与 arr[2] 比较
然后较大值再与 arr[3] 比较
然后较大值再与 arr[4] 比较……
若一直比较至数组末还是没达到 k，返回的就是 arr 数组的最大值
 */