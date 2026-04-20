package p1279;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1279BTests extends AbstractOjTests {
    public CF1279BTests() {
        super("/p1279/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1279B.main(null);
        super.doAssertion(OUTPUT1);
    }

    // 补充用例
    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1279B.main(null);
        super.doAssertion(OUTPUT2);
    }
}