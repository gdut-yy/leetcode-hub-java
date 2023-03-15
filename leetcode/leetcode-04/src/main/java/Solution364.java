import java.util.ArrayList;
import java.util.List;

public class Solution364 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int sum = 0;
        int levelSum = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for (NestedInteger n : nestedList) {
                if (n.isInteger()) {
                    levelSum += n.getInteger();
                } else {
                    nextLevel.addAll(n.getList());
                }
            }
            nestedList = nextLevel;
            sum += levelSum;
        }
        return sum;
    }

    public interface NestedInteger {
//        // Constructor initializes an empty nested list.
//        public NestedInteger();
//
//        // Constructor initializes a single integer.
//        public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
/*
$364. 加权嵌套序列和 II
https://leetcode.cn/problems/nested-list-weight-sum-ii/

给你一个整数嵌套列表 nestedList ，每一个元素要么是一个整数，要么是一个列表（这个列表中的每个元素也同样是整数或列表）。
整数的 深度 取决于它位于多少个列表内部。例如，嵌套列表 [1,[2,2],[[3],2],1] 的每个整数的值都等于它的 深度 。令 maxDepth 是任意整数的 最大深度 。
整数的 权重 为 maxDepth - (整数的深度) + 1 。
将 nestedList 列表中每个整数先乘权重再求和，返回该加权和。
提示：
1 <= nestedList.length <= 50
嵌套列表中整数的值在范围 [-100, 100]
任意整数的最大 深度 小于等于 50
 */
