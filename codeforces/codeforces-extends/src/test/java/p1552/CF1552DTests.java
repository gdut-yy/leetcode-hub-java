package p1552;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1552DTests extends AbstractOjTests {
    public CF1552DTests() {
        super("/p1552/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1552D.main(null);
        super.doAssertion();
    }
}