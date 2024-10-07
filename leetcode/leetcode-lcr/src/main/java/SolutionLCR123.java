import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionLCR123 {
    public int[] reverseBookList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.reverse(list);
        return list.stream().mapToInt(i -> i).toArray();
    }
}
/*
LCR 123. 图书整理 I
https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/description/

书店店员有一张链表形式的书单，每个节点代表一本书，节点中的值表示书的编号。为更方便整理书架，店员需要将书单倒过来排列，就可以从最后一本书开始整理，逐一将书放回到书架上。请倒序返回这个书单链表。
提示：
0 <= 链表长度 <= 10000
 */