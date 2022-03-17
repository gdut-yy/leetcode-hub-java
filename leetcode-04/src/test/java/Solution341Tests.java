import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution341Tests {
    static class NestedIntegerImpl implements Solution341.NestedInteger {
        private final Integer integer;
        private final List<Solution341.NestedInteger> list;

        public NestedIntegerImpl(Integer integer) {
            this.integer = integer;
            this.list = new ArrayList<>();
        }

        public NestedIntegerImpl(List<Integer> integers) {
            this.integer = null;
            this.list = new ArrayList<>();
            for (Integer integer : integers) {
                this.list.add(new NestedIntegerImpl(integer));
            }
        }

        @Override
        public boolean isInteger() {
            return !Objects.isNull(integer);
        }

        @Override
        public Integer getInteger() {
            return integer;
        }

        @Override
        public List<Solution341.NestedInteger> getList() {
            return list;
        }
    }

    @Test
    public void example1() {
        Solution341.NestedInteger nestedInteger1 = new NestedIntegerImpl(List.of(1, 1));
        Solution341.NestedInteger nestedInteger2 = new NestedIntegerImpl(2);
        Solution341.NestedInteger nestedInteger3 = new NestedIntegerImpl(List.of(1, 1));
        List<Solution341.NestedInteger> nestedList = List.of(nestedInteger1, nestedInteger2, nestedInteger3);
        List<Integer> expected = List.of(1, 1, 2, 1, 1);

        Solution341.NestedIterator i = new Solution341.NestedIterator(nestedList);
        List<Integer> actual = new ArrayList<>();
        while (i.hasNext()) {
            actual.add(i.next());
        }
        Assertions.assertEquals(expected, actual);
    }
}
