package p1703;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1703ATests extends AbstractOjTests {
    public CF1703ATests() {
        super("/p1703/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1703A.main(null);
        super.doAssertion();
    }
}
