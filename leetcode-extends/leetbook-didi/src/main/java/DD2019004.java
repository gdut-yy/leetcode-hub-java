import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DD2019004 {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        // t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = scanner.nextInt();
        }

        int idx = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums) {
            stack.push(num);
            while (!stack.isEmpty() && idx < 4 && TARGET[idx] < stack.peek()) {
                stack.pop();
                idx++;
            }
        }
        out.println(stack.isEmpty() ? "Yes" : "No");
    }

    private static final int[] TARGET = {1, 2, 3, 4};
}
/*
DD-2019004. 火车编组题
https://leetcode.cn/problems/hB3NFW/

铁路的货车编组站如上图，货车编组站，是利用人字形的铁路道岔，将货车车厢的顺序进行重新调整，以便于货车在不同的目的地进行车厢解挂。
现编组站有一人字形铁路道岔，A 点有 k 节车厢，所有车厢都须从 A 点进入，经 C 点道岔后，重新编组到 B 点。
例如，A 点有车厢 1-2-3(从左至右)，经 C 编组，到 B 点后，可以被编组成 1-2-3， 1-3-2，2-1-3，2-3-1，3-2-1 等几种可能的编组。
问:
A 有车厢编组 (从左至右)1-2-3-4，列车在经过编组后，能否在 B 点编组成 4-1-3-2 的顺序，请给出算法证明?
格式：
输入：
- 输入 4 行，每行依次表示车厢编号。
输出：
- Yes/No
示例：
输入：
4
1
3
2
输出：No

栈模拟
相似题目: 946. 验证栈序列
https://leetcode.cn/problems/validate-stack-sequences/
 */