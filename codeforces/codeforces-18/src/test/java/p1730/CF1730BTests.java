package p1730;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1730BTests extends AbstractOjTests {
    public CF1730BTests() {
        super("/p1730/B/");
    }

    @Test
    @Disabled("浮点数")
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1730B.main(null);
        super.doAssertion();
    }
}