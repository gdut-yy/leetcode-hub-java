import java.util.HashSet;
import java.util.Set;

public class SolutionP3860 {
    public int uniqueEmailGroups(String[] emails) {
        Set<String> groups = new HashSet<>();
        for (String email : emails) {
            String emailLowercase = email.toLowerCase();
            StringBuilder sb = new StringBuilder();
            int atIdx = email.indexOf('@');
            for (int i = 0; i < atIdx && emailLowercase.charAt(i) != '+'; i++) {
                char c = emailLowercase.charAt(i);
                if (c != '.') {
                    sb.append(c);
                }
            }
            sb.append(emailLowercase.substring(atIdx));
            groups.add(sb.toString());
        }
        return groups.size();
    }
}
/*
$3860. 不同邮件组
https://leetcode.cn/problems/unique-email-groups/description/

给定一个字符串数组 emails，其中每个字符串是一个有效的邮件地址。
如果两个邮件地址的 规范化 本地名称和 规范化 域名名称 都相同，则属于同一组。
规范化规则如下：
- 本地名称是 '@' 符号 之前 的部分。
  - 忽略所有点 '.'。
  - 忽略第一个 '+' 之后的所有内容，如果存在的话。
  - 转换为小写。
- 域名是 '@' 符号 后面 的部分。
  - 转换为小写。
返回一个整数，表示规范化后的 不同 电子邮件组的数量。
示例 1：
输入：emails = ["test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"]
输出：2
示例 2：
输入：emails = ["A@B.com", "a@b.com", "ab+xy@b.com", "a.b@b.com"]
输出：2
示例 3：
输入：emails = ["a.b+c.d+e@DoMain.com", "ab+xyz@domain.com", "ab@domain.com"]
输出：1
提示：
1 <= emails.length <= 1000
1 <= emails[i].length <= 100
emails[i] 包含大小写英文字母，数字，以及字符 '.'，'+' 和 '@'。
每个 emails[i] 包含 恰好 一个 '@' 字符。
所有本地名称和域名都不为空；本地名不能以 '+' 开头。
域名以 ".com" 后缀结尾，并且在 ".com" 之前至少包含一个字符。
 */