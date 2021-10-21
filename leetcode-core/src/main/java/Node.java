import com.alibaba.fastjson.JSON;

public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public static boolean assertNodeEquals(Node expected, Node actual) {
        if (expected == null && actual == null) {
            return true;
        } else if (expected == null || actual == null) {
            return false;
        } else if (expected.val != actual.val) {
            return false;
        } else {
            return assertNodeEquals(expected.next, actual.next);
        }
    }

    public static boolean assertNodeEquals2(Node expected, Node actual) {
        String expectedJson = JSON.toJSONString(expected);
        String actualJson = JSON.toJSONString(actual);
        return expectedJson.equals(actualJson);
    }
}
