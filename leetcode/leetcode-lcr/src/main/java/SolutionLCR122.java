public class SolutionLCR122 {
    public String pathEncryption(String s) {
        return s.replace(".", " ");
    }
}
/*
LCR 122. 路径加密
https://leetcode.cn/problems/ti-huan-kong-ge-lcof/description/

假定一段路径记作字符串 path，其中以 "." 作为分隔符。现需将路径加密，加密方法为将 path 中的分隔符替换为空格 " "，请返回加密后的字符串。
限制：
0 <= path.length <= 10000

String#replace()
 */