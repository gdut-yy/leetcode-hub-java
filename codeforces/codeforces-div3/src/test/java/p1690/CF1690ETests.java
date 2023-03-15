package p1690;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1690ETests extends AbstractOjTests {
    public CF1690ETests() {
        super("/p1690/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1690E.main(null);
        super.doAssertion();
    }
}
