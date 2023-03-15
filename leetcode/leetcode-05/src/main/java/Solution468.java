import java.util.regex.Pattern;

public class Solution468 {
    // IPV4_SUB = "([1-9]?\\d|1\\d{2}|2[0-4]\\d|25[0-5])";
    // IPV4_SUB(\\.IPV4_SUB){3}
    private static final Pattern IPV4 = Pattern.compile("^([1-9]?\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.([1-9]?\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}$");

    // IPV6_SUB = "[\\da-fA-F]{1,4}";
    // IPV6_SUB(:IPV6_SUB){7}
    private static final Pattern IPV6 = Pattern.compile("^[\\da-fA-F]{1,4}(:[\\da-fA-F]{1,4}){7}$");

    public String validIPAddress(String queryIP) {
        if (IPV4.matcher(queryIP).matches()) {
            return "IPv4";
        } else if (IPV6.matcher(queryIP).matches()) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }
}
/*
468. 验证IP地址
https://leetcode.cn/problems/validate-ip-address/

给定一个字符串 queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的 IP 地址，返回 "Neither" 。
有效的IPv4地址 是 “x1.x2.x3.x4” 形式的IP地址。 其中 0 <= xi <= 255 且 xi 不能包含 前导零。
例如: “192.168.1.1” 、 “192.168.1.0” 为有效IPv4地址， “192.168.01.1” 为无效IPv4地址; “192.168.1.00” 、 “192.168@1.1” 为无效IPv4地址。
一个有效的IPv6地址 是一个格式为“x1:x2:x3:x4:x5:x6:x7:x8” 的IP地址，其中:
- 1 <= xi.length <= 4
- xi 是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。
- 在 xi 中允许前导零。
例如 "2001:0db8:85a3:0000:0000:8a2e:0370:7334" 和 "2001:db8:85a3:0:0:8A2E:0370:7334" 是有效的 IPv6 地址，
而 "2001:0db8:85a3::8A2E:037j:7334" 和 "02001:0db8:85a3:0000:0000:8a2e:0370:7334" 是无效的 IPv6 地址。
提示：
queryIP 仅由英文字母，数字，字符 '.' 和 ':' 组成。

正则表达式。
 */