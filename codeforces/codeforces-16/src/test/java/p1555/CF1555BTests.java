package p1555;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1555BTests extends AbstractOjTests {
    public CF1555BTests() {
        super("/p1555/B/");
    }

    @Test
    @Disabled("floating")
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1555B.main(null);
        super.doAssertion(OUTPUT1);
    }
}