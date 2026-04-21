package p134;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import p137.CF137D;

import java.io.IOException;

public class CF134BTests extends AbstractOjTests {
    public CF134BTests() {
        super("/p134/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF134B.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF134B.main(null);
        super.doAssertion(OUTPUT2);
    }
}