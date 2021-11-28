import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5923Tests {
    private final Solution5923 solution5923 = new Solution5923();

    @Test
    public void example1() {
        String street = "H..H";
        int expected = 2;
        Assertions.assertEquals(expected, solution5923.minimumBuckets(street));
    }

    @Test
    public void example2() {
        String street = ".H.H.";
        int expected = 1;
        Assertions.assertEquals(expected, solution5923.minimumBuckets(street));
    }

    @Test
    public void example3() {
        String street = ".HHH.";
        int expected = -1;
        Assertions.assertEquals(expected, solution5923.minimumBuckets(street));
    }

    @Test
    public void example4() {
        String street = "H";
        int expected = -1;
        Assertions.assertEquals(expected, solution5923.minimumBuckets(street));
    }

    @Test
    public void example5() {
        String street = ".";
        int expected = 0;
        Assertions.assertEquals(expected, solution5923.minimumBuckets(street));
    }

    // 补充用例
    @Test
    public void example6() {
        String street = ".HH.H.H.H..";
        int expected = 3;
        Assertions.assertEquals(expected, solution5923.minimumBuckets(street));
    }
}
