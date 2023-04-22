package p1365;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1365FTests extends AbstractOjTests {
    public CF1365FTests() {
        super("/p1365/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1365F.main(null);
        super.doAssertion();
    }
}