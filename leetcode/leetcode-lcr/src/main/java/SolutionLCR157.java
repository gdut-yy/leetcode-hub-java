import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionLCR157 {
    char[] cs;
    int n;
    List<String> ans;

    public String[] goodsOrder(String s) {
        cs = s.toCharArray();
        n = s.length();
        ans = new ArrayList<>();
        dfs(0);
        return ans.toArray(String[]::new);
    }

    private void dfs(int i) {
        if (i == n) {
            ans.add(new String(cs));
        } else {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (!set.contains(cs[j])) {
                    set.add(cs[j]);
                    swap(i, j);
                    dfs(i + 1);
                    swap(i, j);
                }
            }
        }
    }

    private void swap(int i, int j) {
        char ch = cs[i];
        cs[i] = cs[j];
        cs[j] = ch;
    }
}
/*
LCR 157. 套餐内商品的排列顺序
https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/

某店铺将用于组成套餐的商品记作字符串 goods，其中 goods[i] 表示对应商品。请返回该套餐内所含商品的 全部排列方式 。
返回结果 无顺序要求，但不能含有重复的元素。
提示：
1 <= goods.length <= 8

相似题目: 面试题 08.08. 有重复字符串的排列组合
https://leetcode.cn/problems/permutation-ii-lcci/
 */