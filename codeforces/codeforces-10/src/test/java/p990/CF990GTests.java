package p990;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF990GTests extends AbstractOjTests {
    public CF990GTests() {
        super("/p990/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF990G.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF990G.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        CF990G.main(null);
        super.doAssertion(OUTPUT3);
    }
}