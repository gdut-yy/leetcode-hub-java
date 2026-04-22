package p821;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF821ETests extends AbstractOjTests {
    public CF821ETests() {
        super("/p821/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF821E.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF821E.main(null);
        super.doAssertion(OUTPUT2);
    }
}