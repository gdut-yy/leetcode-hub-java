package p1833;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1833GTests extends AbstractOjTests {
    public CF1833GTests() {
        super("/p1833/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1833G.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1833G.main(null);
        super.doAssertion(OUTPUT2);
    }
}