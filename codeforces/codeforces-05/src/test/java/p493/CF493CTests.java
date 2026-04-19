package p493;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF493CTests extends AbstractOjTests {
    public CF493CTests() {
        super("/p493/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF493C.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF493C.main(null);
        super.doAssertion(OUTPUT2);
    }
}