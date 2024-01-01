package p1634;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1634FTests extends AbstractOjTests {
    public CF1634FTests() {
        super("/p1634/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1634F.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1634F.main(null);
        super.doAssertion(OUTPUT2);
    }
}
