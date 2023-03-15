package p1800;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1800ATests extends AbstractOjTests {
    public CF1800ATests() {
        super("/p1800/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1800A.main(null);
        super.doAssertion();
    }
}
