public class Solution2166 {
    static class Bitset {
        private final java.util.BitSet bitSet;
        private final int size;

        public Bitset(int size) {
            this.size = size;
            this.bitSet = new java.util.BitSet(size);
            this.bitSet.set(0, size, false);
        }

        public void fix(int idx) {
            this.bitSet.set(idx, true);
        }

        public void unfix(int idx) {
            this.bitSet.set(idx, false);
        }

        public void flip() {
            this.bitSet.flip(0, this.size);
        }

        public boolean all() {
            return this.bitSet.cardinality() == this.size;
        }

        public boolean one() {
            return this.bitSet.cardinality() > 0;
        }

        public int count() {
            return this.bitSet.cardinality();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < size; i++) {
                if (bitSet.get(i)) {
                    stringBuilder.append(1);
                } else {
                    stringBuilder.append(0);
                }
            }
            return stringBuilder.toString();
        }
    }
}
/*
2166. 设计位集
https://leetcode-cn.com/problems/design-bitset/

第 279 场周赛 T3。

位集 Bitset 是一种能以紧凑形式存储位的数据结构。
请你实现 Bitset 类。
- Bitset(int size) 用 size 个位初始化 Bitset ，所有位都是 0 。
- void fix(int idx) 将下标为 idx 的位上的值更新为 1 。如果值已经是 1 ，则不会发生任何改变。
- void unfix(int idx) 将下标为 idx 的位上的值更新为 0 。如果值已经是 0 ，则不会发生任何改变。
- void flip() 翻转 Bitset 中每一位上的值。换句话说，所有值为 0 的位将会变成 1 ，反之亦然。
- boolean all() 检查 Bitset 中 每一位 的值是否都是 1 。如果满足此条件，返回 true ；否则，返回 false 。
- boolean one() 检查 Bitset 中 是否 至少一位 的值是 1 。如果满足此条件，返回 true ；否则，返回 false 。
- int count() 返回 Bitset 中值为 1 的位的 总数 。
- String toString() 返回 Bitset 的当前组成情况。注意，在结果字符串中，第 i 个下标处的字符应该与 Bitset 中的第 i 位一致。

java.util.BitSet API 调用
 */