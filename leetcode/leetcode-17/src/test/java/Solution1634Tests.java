import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1634Tests {
    private final Solution1634 solution1634 = new Solution1634();

    @Test
    public void example1() {
        Solution1634.PolyNode poly1 = new Solution1634.PolyNode(1, 1);
        Solution1634.PolyNode poly2 = new Solution1634.PolyNode(1, 0);
        Solution1634.PolyNode expected = new Solution1634.PolyNode(1, 1);
        expected.next = new Solution1634.PolyNode(1, 0);
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution1634.addPoly(poly1, poly2)));
    }

    @Test
    public void example2() {
        Solution1634.PolyNode poly1 = new Solution1634.PolyNode(2, 2);
        poly1.next = new Solution1634.PolyNode(4, 1);
        poly1.next.next = new Solution1634.PolyNode(3, 0);
        Solution1634.PolyNode poly2 = new Solution1634.PolyNode(3, 2);
        poly2.next = new Solution1634.PolyNode(-4, 1);
        poly2.next.next = new Solution1634.PolyNode(-1, 0);
        Solution1634.PolyNode expected = new Solution1634.PolyNode(5, 2);
        expected.next = new Solution1634.PolyNode(2, 0);
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution1634.addPoly(poly1, poly2)));
    }

    @Test
    public void example3() {
        Solution1634.PolyNode poly1 = new Solution1634.PolyNode(1, 2);
        Solution1634.PolyNode poly2 = new Solution1634.PolyNode(-1, 2);
        Solution1634.PolyNode expected = null;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution1634.addPoly(poly1, poly2)));
    }
}
