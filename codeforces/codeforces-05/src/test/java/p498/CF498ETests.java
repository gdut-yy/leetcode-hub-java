package p498;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF498ETests extends AbstractOjTests {
    public CF498ETests() {
        super("/p498/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF498E.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF498E.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        CF498E.main(null);
        super.doAssertion(OUTPUT3);
    }

    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example4() throws IOException {
        super.doSetSystemInOut(INPUT4);
        CF498E.main(null);
        super.doAssertion(OUTPUT4);
    }
}