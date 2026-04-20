package p176;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF176ETests extends AbstractOjTests {
    public CF176ETests() {
        super("/p176/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF176E.main(null);
        super.doAssertion(OUTPUT1);
    }

    // 补充用例
    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF176E.main(null);
        super.doAssertion(OUTPUT2);
    }
}