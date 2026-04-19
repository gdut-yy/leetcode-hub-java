package p498;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF498BTests extends AbstractOjTests {
    public CF498BTests() {
        super("/p498/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF498B.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF498B.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        CF498B.main(null);
        super.doAssertion(OUTPUT3);
    }

    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example4() throws IOException {
        super.doSetSystemInOut(INPUT4);
        CF498B.main(null);
        super.doAssertion(OUTPUT4);
    }
}
