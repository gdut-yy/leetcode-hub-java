package p1073;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1073CTests extends AbstractOjTests {
    public CF1073CTests() {
        super("/p1073/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1073C.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1073C.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        CF1073C.main(null);
        super.doAssertion(OUTPUT3);
    }
}