import java.util.Arrays;
import java.util.stream.Collectors;

public class SolutionO45 {
    public String minNumber(int[] nums) {
        return Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((x, y) -> (x + y).compareTo(y + x))
                .collect(Collectors.joining());
    }
}
/*
剑指 Offer 45. 把数组排成最小的数
https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/

输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。

自定义排序。
"10" + "2" = "102"
"2" + "10" = "210"

"102" < "210" => "10" < "2"
 */