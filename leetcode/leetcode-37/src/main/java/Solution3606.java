import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution3606 {
    record Coupon(String cod, int busType) {
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        List<Coupon> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String cod = code[i];
            String bus = businessLine[i];
            if (checkCod(cod) && checkBus(bus) && isActive[i]) {
                ans.add(new Coupon(cod, getBusType(bus)));
            }
        }
        ans.sort(Comparator.comparing(Coupon::busType).thenComparing(Coupon::cod));
        return ans.stream().map(Coupon::cod).toList();
    }

    private int getBusType(String bus) {
        if ("electronics".equals(bus)) return 0;
        else if ("grocery".equals(bus)) return 1;
        else if ("pharmacy".equals(bus)) return 2;
        else if ("restaurant".equals(bus)) return 3;
        return -1;
    }

    private boolean checkBus(String bus) {
        return getBusType(bus) != -1;
    }

    private boolean checkCod(String cod) {
        if (cod.isEmpty()) return false;
        for (char c : cod.toCharArray()) {
            if (!Character.isLowerCase(c)
                    && !Character.isUpperCase(c)
                    && !Character.isDigit(c)
                    && c != '_') {
                return false;
            }
        }
        return true;
    }
}
/*
3606. 优惠券校验器
https://leetcode.cn/problems/coupon-code-validator/description/

第 457 场周赛 T1。

给你三个长度为 n 的数组，分别描述 n 个优惠券的属性：code、businessLine 和 isActive。其中，第 i 个优惠券具有以下属性：
- code[i]：一个 字符串，表示优惠券的标识符。
- businessLine[i]：一个 字符串，表示优惠券所属的业务类别。
- isActive[i]：一个 布尔值，表示优惠券是否当前有效。
当以下所有条件都满足时，优惠券被认为是 有效的 ：
1.code[i] 不能为空，并且仅由字母数字字符（a-z、A-Z、0-9）和下划线（_）组成。
2.businessLine[i] 必须是以下四个类别之一："electronics"、"grocery"、"pharmacy"、"restaurant"。
3.isActive[i] 为 true 。
返回所有 有效优惠券的标识符 组成的数组，按照以下规则排序：
- 先按照其 businessLine 的顺序排序："electronics"、"grocery"、"pharmacy"、"restaurant"。
- 在每个类别内，再按照 标识符的字典序（升序）排序。
提示：
n == code.length == businessLine.length == isActive.length
1 <= n <= 100
0 <= code[i].length, businessLine[i].length <= 100
code[i] 和 businessLine[i] 由可打印的 ASCII 字符组成。
isActive[i] 的值为 true 或 false。

模拟。
 */