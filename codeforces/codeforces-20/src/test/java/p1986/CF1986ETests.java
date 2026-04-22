package p1986;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

public class CF1986ETests extends AbstractOjTests {
    public CF1986ETests() {
        super("/p1986/E/");
    }

    @Test
    public void test1() throws Exception {
        doSetSystemInOut(INPUT1);
        CF1986E.main(new String[]{});
        doAssertion(OUTPUT1);
    }
}
