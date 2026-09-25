import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SfTech220619T1Tests {
    private final SfTech220619T1 sfTech220619T1 = new SfTech220619T1();

    @Test
    public void example1() {
        String graph = "1->2,2->3,3->1";
        Assertions.assertTrue(sfTech220619T1.hasCycle(graph));
    }

    @Test
    public void example2() {
        String graph = "1->4,2->5,3->6,3->7,4->8,5->8,5->9,6->9,6->11,7->11,8->12,9->12,9->13,10->13,10->14,11->10,11->14";
        Assertions.assertFalse(sfTech220619T1.hasCycle(graph));
    }

    @Test
    public void example3() {
        String graph = "1->4,2->5,3->6,3->7,4->8,5->8,5->9,6->9,6->11,7->11,8->12,9->12,9->13,10->6,10->13,10->14,11->10,11->14";
        Assertions.assertTrue(sfTech220619T1.hasCycle(graph));
    }
}
