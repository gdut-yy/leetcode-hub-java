import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution831 {
    public String maskPII(String s) {
        // 电子邮箱
        if (isEmail(s)) {
            s = s.toLowerCase(Locale.ENGLISH);
            int index = s.indexOf("@");
            return String.format(Locale.ENGLISH, "%s*****%s", s.charAt(0), s.substring(index - 1));
        }
        // 电话号码
        else {
            // 保留 0-9 数字
            String phoneNum = s.replaceAll("\\D+", "");
            int len = phoneNum.length();
            String format = "***-***-%s";
            switch (len) {
                case 11:
                    format = "+*-***-***-%s";
                    break;
                case 12:
                    format = "+**-***-***-%s";
                    break;
                case 13:
                    format = "+***-***-***-%s";
                    break;
            }
            return String.format(Locale.ENGLISH, format, phoneNum.substring(phoneNum.length() - 4));
        }
    }

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z]{2,}@[a-zA-Z]{2,}.[a-zA-Z]{2,}$");

    private boolean isEmail(String s) {
        Matcher matcher = EMAIL_PATTERN.matcher(s);
        return matcher.matches();
    }
}
/*
831. 隐藏个人信息
https://leetcode-cn.com/problems/masking-personal-information/

第 83 场周赛 T2。

给你一条个人信息字符串 s ，可能表示一个 邮箱地址 ，也可能表示一串 电话号码 。返回按如下规则 隐藏 个人信息后的结果：
电子邮件地址：
一个电子邮件地址由以下部分组成：
- 一个 名字 ，由大小写英文字母组成，后面跟着
- 一个 '@' 字符，后面跟着
- 一个 域名 ，由大小写英文字母和一个位于中间的 '.' 字符组成。'.' 不会是域名的第一个或者最后一个字符。
要想隐藏电子邮件地址中的个人信息：
- 名字 和 域名 部分的大写英文字母应当转换成小写英文字母。
- 名字 中间的字母（即，除第一个和最后一个字母外）必须用 5 个 "*****" 替换。
电话号码：
一个电话号码应当按下述格式组成：
- 电话号码可以由 10-13 位数字组成
- 后 10 位构成 本地号码
- 前面剩下的 0-3 位，构成 国家代码
- 利用 {'+', '-', '(', ')', ' '} 这些 分隔字符 按某种形式对上述数字进行分隔
要想隐藏电话号码中的个人信息：
- 移除所有 分隔字符
- 隐藏个人信息后的电话号码应该遵从这种格式：
  - "***-***-XXXX" 如果国家代码为 0 位数字
  - "+*-***-***-XXXX" 如果国家代码为 1 位数字
  - "+**-***-***-XXXX" 如果国家代码为 2 位数字
  - "+***-***-***-XXXX" 如果国家代码为 3 位数字
- "XXXX" 是最后 4 位 本地号码

本题有取巧的成分。字符串 S，它可能是一个 邮箱地址 ，也可能是一串 电话号码。
根据这点可以通过 @ 字符进行区分（实际项目中需用正则表达式更精确进行判断）。
字符串中仅保留数字可用 String.replaceAll("\\D+", "");
 */