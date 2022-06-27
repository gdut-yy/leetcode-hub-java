import java.util.ArrayList;
import java.util.List;

public class Solution906 {
    private static final long[] TABLE = {
            1L,
            4L,
            9L,
            121L,
            484L,
            10201L,
            12321L,
            14641L,
            40804L,
            44944L,
            1002001L,
            1234321L,
            4008004L,
            100020001L,
            102030201L,
            104060401L,
            121242121L,
            123454321L,
            125686521L,
            400080004L,
            404090404L,
            10000200001L,
            10221412201L,
            12102420121L,
            12345654321L,
            40000800004L,
            1000002000001L,
            1002003002001L,
            1004006004001L,
            1020304030201L,
            1022325232201L,
            1024348434201L,
            1210024200121L,
            1212225222121L,
            1214428244121L,
            1232346432321L,
            1234567654321L,
            4000008000004L,
            4004009004004L,
            100000020000001L,
            100220141022001L,
            102012040210201L,
            102234363432201L,
            121000242000121L,
            121242363242121L,
            123212464212321L,
            123456787654321L,
            400000080000004L,
            10000000200000001L,
            10002000300020001L,
            10004000600040001L,
            10020210401202001L,
            10022212521222001L,
            10024214841242001L,
            10201020402010201L,
            10203040504030201L,
            10205060806050201L,
            10221432623412201L,
            10223454745432201L,
            12100002420000121L,
            12102202520220121L,
            12104402820440121L,
            12122232623222121L,
            12124434743442121L,
            12321024642012321L,
            12323244744232321L,
            12343456865434321L,
            12345678987654321L,
            40000000800000004L,
            40004000900040004L,
            1000000002000000001L,
            1000220014100220001L,
            1002003004003002001L,
            1002223236323222001L,
            1020100204020010201L,
            1020322416142230201L,
            1022123226223212201L,
            1022345658565432201L,
            1210000024200000121L,
            1210242036302420121L,
            1212203226223022121L,
            1212445458545442121L,
            1232100246420012321L,
            1232344458544432321L,
            1234323468643234321L,
            4000000008000000004L
    };

    public int superpalindromesInRange(String left, String right) {
        long leftLong = Long.parseLong(left);
        long rightLong = Long.parseLong(right);
        int leftIdx = binarySearchLeftBound(TABLE, leftLong);
        int rightIdx = binarySearchRightBound(TABLE, rightLong);
        return rightIdx - leftIdx + 1;
    }

    private int binarySearchLeftBound(long[] nums, long target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }

    private static int binarySearchRightBound(long[] nums, long target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1;
    }

    // 打表
    public static void main(String[] args) {
        List<List<String>> dpList = new ArrayList<>();

        // 长度为 0
        List<String> len0List = new ArrayList<>();
        len0List.add("");
        dpList.add(len0List);

        // 长度为 1
        // 0,1,2,3,4,5,6,7,8,9
        List<String> len1List = new ArrayList<>();
        for (int digital = 0; digital <= 9; digital++) {
            len1List.add(String.valueOf(digital));
        }
        dpList.add(len1List);

        // 长度 2 到 len
        for (int len = 2; len < 11; len++) {
            // 长度-2 的 List
            List<String> preList = dpList.get(len - 2);
            List<String> curList = new ArrayList<>();
            for (int j = 0; j <= 9; j++) {
                for (String middle : preList) {
                    curList.add(j + middle + j);
                }
            }
            dpList.add(curList);
        }
//        System.out.println(dpList);
        for (int i = 1; i < dpList.size(); i++) {
            for (String decString : dpList.get(i)) {
                long num = Long.parseLong(decString);
                if (decString.charAt(0) != '0') {
                    long power = num * num;
                    if (check(String.valueOf(power))) {
                        System.out.println(num + ":" + power);
                    }
                }
            }
        }
    }

    private static boolean check(String string) {
        String reverseString = new StringBuilder(string).reverse().toString();
        return string.equals(reverseString);
    }
}
/*
906. 超级回文数
https://leetcode.cn/problems/super-palindromes/

第 102 场周赛 T4。

如果一个正整数自身是回文数，而且它也是一个回文数的平方，那么我们称这个数为超级回文数。
现在，给定两个正整数 L 和 R （以字符串形式表示），返回包含在范围 [L, R] 中的超级回文数的数目。
提示：
1 <= len(L) <= 18
1 <= len(R) <= 18
L 和 R 是表示 [1, 10^18) 范围的整数的字符串。
int(L) <= int(R)

1:1
2:4
3:9
11:121
22:484
101:10201
111:12321
121:14641
202:40804
212:44944
1001:1002001
1111:1234321
2002:4008004
10001:100020001
10101:102030201
10201:104060401
11011:121242121
11111:123454321
11211:125686521
20002:400080004
20102:404090404
100001:10000200001
101101:10221412201
110011:12102420121
111111:12345654321
200002:40000800004
1000001:1000002000001
1001001:1002003002001
1002001:1004006004001
1010101:1020304030201
1011101:1022325232201
1012101:1024348434201
1100011:1210024200121
1101011:1212225222121
1102011:1214428244121
1110111:1232346432321
1111111:1234567654321
2000002:4000008000004
2001002:4004009004004
10000001:100000020000001
10011001:100220141022001
10100101:102012040210201
10111101:102234363432201
11000011:121000242000121
11011011:121242363242121
11100111:123212464212321
11111111:123456787654321
20000002:400000080000004
100000001:10000000200000001
100010001:10002000300020001
100020001:10004000600040001
100101001:10020210401202001
100111001:10022212521222001
100121001:10024214841242001
101000101:10201020402010201
101010101:10203040504030201
101020101:10205060806050201
101101101:10221432623412201
101111101:10223454745432201
110000011:12100002420000121
110010011:12102202520220121
110020011:12104402820440121
110101011:12122232623222121
110111011:12124434743442121
111000111:12321024642012321
111010111:12323244744232321
111101111:12343456865434321
111111111:12345678987654321
200000002:40000000800000004
200010002:40004000900040004
1000000001:1000000002000000001
 */