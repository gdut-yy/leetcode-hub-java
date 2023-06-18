package p506;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF506DTests extends AbstractOjTests {
    public CF506DTests() {
        super("/p506/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF506D.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF506D.main(null);
        super.doAssertion(OUTPUT2);
    }

    // 补充用例
    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        CF506D.main(null);
        super.doAssertion(OUTPUT3);
    }
}