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

    private static final Pattern emailPattern = Pattern.compile("^[a-zA-Z]{2,}@[a-zA-Z]{2,}.[a-zA-Z]{2,}$");

    private boolean isEmail(String s) {
        Matcher matcher = emailPattern.matcher(s);
        return matcher.matches();
    }
}
/*
831. 隐藏个人信息
https://leetcode-cn.com/problems/masking-personal-information/

第 83 场周赛 T2。
本题有取巧的成分。字符串 S，它可能是一个 邮箱地址 ，也可能是一串 电话号码。
根据这点可以通过 @ 字符进行区分（实际项目中需用正则表达式更精确进行判断）。
字符串中仅保留数字可用 String.replaceAll("\\D+", "");
 */