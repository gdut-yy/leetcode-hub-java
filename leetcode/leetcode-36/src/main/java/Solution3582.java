public class Solution3582 {
    public String generateTag(String caption) {
        caption = ("#" + caption.strip()).toLowerCase();
        StringBuilder ans = new StringBuilder("#");
        for (int i = 1; i < caption.length(); i++) {
            char c = caption.charAt(i);
            if (c == ' ') continue;
            if (caption.charAt(i - 1) == ' ') {
                ans.append(Character.toUpperCase(c));
            } else {
                ans.append(c);
            }
        }
        return ans.substring(0, Math.min(100, ans.length()));
    }
}
/*
3582. 为视频标题生成标签
https://leetcode.cn/problems/generate-tag-for-video-caption/description/

第 454 场周赛 T1。

给你一个字符串 caption，表示一个视频的标题。
需要按照以下步骤 按顺序 生成一个视频的 有效标签 ：
1.将 所有单词 组合为单个 驼峰命名字符串 ，并在前面加上 '#'。驼峰命名字符串 指的是除第一个单词外，其余单词的首字母大写，且每个单词的首字母之后的字符必须是小写。
2.移除 所有不是英文字母的字符，但 保留 第一个字符 '#'。
3.将结果 截断 为最多 100 个字符。
对 caption 执行上述操作后，返回生成的 标签 。
提示：
1 <= caption.length <= 150
caption 仅由英文字母和 ' ' 组成。

模拟。WA了5次，细节是魔鬼。
时间复杂度 O(n)。
 */