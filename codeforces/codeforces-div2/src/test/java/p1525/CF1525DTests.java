package p1525;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1525DTests extends AbstractOjTests {
    public CF1525DTests() {
        super("/p1525/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1525D.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1525D.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        CF1525D.main(null);
        super.doAssertion(OUTPUT3);
    }
}