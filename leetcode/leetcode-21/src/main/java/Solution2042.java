import java.util.ArrayList;
import java.util.List;

public class Solution2042 {
    public boolean areNumbersAscending(String s) {
        String[] tokens = s.split(" ");
        List<String> digitalList = new ArrayList<>();
        for (String token : tokens) {
            if (isDigital(token)) {
                digitalList.add(token);
            }
        }
        for (int i = 1; i < digitalList.size(); i++) {
            int num1 = Integer.parseInt(digitalList.get(i - 1));
            int num2 = Integer.parseInt(digitalList.get(i));
            if (num1 >= num2) {
                return false;
            }
        }
        return true;
    }

    private boolean isDigital(String token) {
        for (char ch : token.toCharArray()) {
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        return true;
    }
}
/*
2042. 检查句子中的数字是否递增
https://leetcode.cn/problems/check-if-numbers-are-ascending-in-a-sentence/

第 263 场周赛 T1。

句子是由若干 token 组成的一个列表，token 间用 单个 空格分隔，句子没有前导或尾随空格。
每个 token 要么是一个由数字 0-9 组成的不含前导零的 正整数 ，要么是一个由小写英文字母组成的 单词 。
示例，"a puppy has 2 eyes 4 legs" 是一个由 7 个 token 组成的句子："2" 和 "4" 是数字，其他像 "puppy" 这样的 tokens 属于单词。
给你一个表示句子的字符串 s ，你需要检查 s 中的 全部 数字是否从左到右严格递增（即，除了最后一个数字，s 中的 每个 数字都严格小于它 右侧 的数字）。
如果满足题目要求，返回 true ，否则，返回 false 。
提示：
3 <= s.length <= 200
s 由小写英文字母、空格和数字 0 到 9 组成（包含 0 和 9）
s 中数字 token 的数目在 2 和 100 之间（包含 2 和 100）
s 中的 token 之间由单个空格分隔
s 中至少有 两个 数字
s 中的每个数字都是一个 小于 100 的 正 数，且不含前导零
s 不含前导或尾随空格

模拟。
 */