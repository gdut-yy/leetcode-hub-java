package p1692;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1692HTests extends AbstractOjTests {
    public CF1692HTests() {
        super("/p1692/H/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1692H.main(null);
        super.doAssertion();
    }
}
