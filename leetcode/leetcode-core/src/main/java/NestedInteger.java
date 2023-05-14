import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/discuss/interview-question/1911645/nestedinteger-implementation-amazon
 * solution339\341\364\385
 */
public class NestedInteger {
    private int val;
    private final List<NestedInteger> list;

    public NestedInteger() {
        this.list = new ArrayList<>();
    }

    public NestedInteger(int val) {
        this.val = val;
        this.list = new ArrayList<>();
    }

    public boolean isInteger() {
        return list.isEmpty();
    }

    public Integer getInteger() {
        return val;
    }

    public void setInteger(int value) {
        this.val = value;
    }

    public void add(NestedInteger nestedInteger) {
        list.add(nestedInteger);
    }

    public List<NestedInteger> getList() {
        return list;
    }
}