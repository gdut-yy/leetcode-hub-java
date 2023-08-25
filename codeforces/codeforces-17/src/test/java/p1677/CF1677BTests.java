package p1677;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1677BTests extends AbstractOjTests {
    public CF1677BTests() {
        super("/p1677/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1677B.main(null);
        super.doAssertion();
    }
}
