import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1963 {
    public int minSwaps(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                stack.push(ch);
            }
            // ch == ']' 出栈
            else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        int sz = stack.size();
        if (sz % 2 == 0) {
            return sz / 2;
        } else {
            return sz / 2 + 1;
        }
    }
}
/*
1963. 使字符串平衡的最小交换次数
https://leetcode-cn.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/

第 253 场周赛 T3。
括号匹配的题型一般可以用栈解决。找规律，统计不能匹配的个数：

    ][     1 次
   ]][[    1 次
  ]]][[[   2 次
 ]]]][[[[  2 次
]]]]][[[[[ 3 次

当不匹配数为偶数时，最小交换次数 = n / 2
当不匹配数为奇数时，最小交换次数 = n / 2 + 1
 */