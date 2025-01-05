import java.util.Arrays;

public class Solution3389 {
    public int makeStringGood(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        int mx = Arrays.stream(cnt).max().orElseThrow();

        int ans = s.length(); // target = 0 时的答案
        int[] f = new int[27];
        for (int target = 1; target <= mx; target++) {
            f[25] = Math.min(cnt[25], Math.abs(cnt[25] - target));
            for (int i = 24; i >= 0; i--) {
                int x = cnt[i];
                int y = cnt[i + 1];
                // 单独操作 x（变成 target 或 0）
                f[i] = f[i + 1] + Math.min(x, Math.abs(x - target));
                // x 变成 target 或 0，y 变成 target
                if (y < target) { // 只有当 y 需要变大时，才去执行第三种操作
                    int t = x > target ? target : 0;
                    f[i] = Math.min(f[i], f[i + 2] + Math.max(x - t, target - y));
                }
            }
            ans = Math.min(ans, f[0]);
        }
        return ans;
    }
}
/*
3389. 使字符频率相等的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-make-character-frequencies-equal/description/

第 428 场周赛 T4。

给你一个字符串 s 。
如果字符串 t 中的字符出现次数相等，那么我们称 t 为 好的 。
你可以执行以下操作 任意次 ：
- 从 s 中删除一个字符。
- 往 s 中添加一个字符。
- 将 s 中一个字母变成字母表中下一个字母。
注意 ，第三个操作不能将 'z' 变为 'a' 。
请你返回将 s 变 好 的 最少 操作次数。
提示：
1 <= s.length <= 2 * 10^4
s 只包含小写英文字母。

1、目标：得到一个 cnt 数组，把所有非零数字都变成一样
2、实际的目标：把所有非零数字都变成 0 或者一样的
3、cnt 数组很短，只有 26，能否暴力枚举所有数字都变成 target 呢？
4、枚举 target = 0,1,2,...,max(cnt)
## 分析
1、第三种操作，是让你节省第一种操作和第二种操作用的
2、能否 a->b->c->...？不能，所以第三种操作仅限于两种相邻字母
## 分类讨论
设 a 出现了 x 次，b 出现了 y 次。
单独操作
x -> 0          操作 x 次
x -> target     操作 abs(x-target) 次
min(x, abs(x-target))
（用操作三）合起来操作
操作三的本质：减少 x，增大 y
如果 y >= target 了，不需要执行操作三，只需要考虑单独操作的情况
所以只需考虑 y < target 的情况，且 y 要变成 target
分类讨论：
  如果 x<=target，那么 x 变成 0      一共操作 max(x-0, target-y) 次
  如果 x>target，那么 x 变成 target  一共操作 max(x-target, target-y) 次
## DP
定义 f[i] 表示操作第 i 种字母到第 25 种字母（z）的最小操作次数
单独操作 f[i] = f[i+1] = min(x, abs(x-target)), x=cnt[i]
合并操作 f[i] = f[i+2] + cost(cnt[i], cnt[i+1])
rating 2934 (clist.by)
 */