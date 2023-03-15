import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1522Tests {
    private final Solution1522 solution1522 = new Solution1522();

    @Test
    public void example1() {
        Solution1522.Node root = new Solution1522.Node(1);
        root.children.add(new Solution1522.Node(3));
        root.children.add(new Solution1522.Node(2));
        root.children.add(new Solution1522.Node(4));
        root.children.get(0).children.add(new Solution1522.Node(5));
        root.children.get(0).children.add(new Solution1522.Node(6));
        int expected = 3;
        Assertions.assertEquals(expected, solution1522.diameter(root));
    }

    @Test
    public void example2() {
        Solution1522.Node root = new Solution1522.Node(1);
        root.children.add(new Solution1522.Node(2));
        root.children.get(0).children.add(new Solution1522.Node(3));
        root.children.get(0).children.add(new Solution1522.Node(4));
        root.children.get(0).children.get(0).children.add(new Solution1522.Node(5));
        root.children.get(0).children.get(1).children.add(new Solution1522.Node(6));
        int expected = 4;
        Assertions.assertEquals(expected, solution1522.diameter(root));
    }

    @Test
    public void example3() {
        Solution1522.Node root = new Solution1522.Node(1);
        root.children.add(new Solution1522.Node(2));
        root.children.add(new Solution1522.Node(3));
        root.children.add(new Solution1522.Node(4));
        root.children.add(new Solution1522.Node(5));
        root.children.get(1).children.add(new Solution1522.Node(6));
        root.children.get(1).children.add(new Solution1522.Node(7));
        root.children.get(2).children.add(new Solution1522.Node(8));
        root.children.get(3).children.add(new Solution1522.Node(9));
        root.children.get(3).children.add(new Solution1522.Node(10));
        root.children.get(1).children.get(1).children.add(new Solution1522.Node(11));
        root.children.get(2).children.get(0).children.add(new Solution1522.Node(12));
        root.children.get(3).children.get(0).children.add(new Solution1522.Node(13));
        root.children.get(1).children.get(1).children.get(0).children.add(new Solution1522.Node(14));
        int expected = 7;
        Assertions.assertEquals(expected, solution1522.diameter(root));
    }
}
