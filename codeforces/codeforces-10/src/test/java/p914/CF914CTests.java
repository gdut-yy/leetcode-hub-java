package p914;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF914CTests extends AbstractOjTests {
    public CF914CTests() {
        super("/p914/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF914C.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF914C.main(null);
        super.doAssertion(OUTPUT2);
    }

    // 补充用例
    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        CF914C.main(null);
        super.doAssertion(OUTPUT3);
    }

    @Test
    public void example4() throws IOException {
        super.doSetSystemInOut(INPUT4);
        CF914C.main(null);
        super.doAssertion(OUTPUT4);
    }
}