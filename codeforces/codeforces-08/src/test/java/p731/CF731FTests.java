package p731;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF731FTests extends AbstractOjTests {
    public CF731FTests() {
        super("/p731/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF731F.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    @Disabled("uses static PrintWriter that gets closed after first run")
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF731F.main(null);
        super.doAssertion(OUTPUT2);
    }
}