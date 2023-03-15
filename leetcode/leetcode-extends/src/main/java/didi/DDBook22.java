package didi;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DDBook22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.nextLine();
        System.out.println(solve(s));
    }

    private static String solve(String s) {
        int m = 0;
        int n = 0;
        for (char ch : s.toCharArray()) {
            Character.UnicodeBlock block = Character.UnicodeBlock.of(ch);
            // http://www.unicode.org/Public/UNIDATA/Blocks.txt
            // 0x4E00,   // 4E00..9FFF; CJK Unified Ideographs
            if (block == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) {
                m++;
            } else if (Character.isLetter(ch)) {
                n++;
            }
        }
//        return String.format("汉字的个数 %d 字母的个数 %d", m, n);
        return String.format("Number of Chinese characters:%d%sNumber of letters:%d", m, System.lineSeparator(), n);
    }
}
/*
计算字符串个数
https://leetcode.cn/leetbook/read/didiglobal2/e7umlv/

输入一行字符串，包含汉字和字母和其他字符，分别统计汉字和字母类型的字符个数 (不能输入换行或者分隔符)
格式：
输入：
- 输入一行字符串
输出：
- 统计出汉字和字母类型的字符个数，换行显示
- 例如：汉字的个数 m 字母的个数 n
示例：
输入：今晚打老虎abc
输出：汉字的个数5 字母的个数3

今晚打老虎abc
滴滴是一家国际化公司
the largest English portal in China, providing
 */