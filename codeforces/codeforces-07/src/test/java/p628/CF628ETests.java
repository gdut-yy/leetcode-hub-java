package p628;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF628ETests extends AbstractOjTests {
    public CF628ETests() {
        super("/p628/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF628E.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF628E.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        CF628E.main(null);
        super.doAssertion(OUTPUT3);
    }
}