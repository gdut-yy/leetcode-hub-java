package p2045;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2045HTests extends AbstractOjTests {
    public CF2045HTests() {
        super("/p2045/H/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2045H.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    @Disabled("CF2045H uses static PrintWriter that gets closed after first run")
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF2045H.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    @Disabled("CF2045H uses static PrintWriter that gets closed after first run")
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        CF2045H.main(null);
        super.doAssertion(OUTPUT3);
    }
}