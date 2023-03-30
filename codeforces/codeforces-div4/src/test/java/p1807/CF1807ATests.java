package p1807;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1807ATests extends AbstractOjTests {
    public CF1807ATests() {
        super("/p1807/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1807A.main(null);
        super.doAssertion();
    }
}
