package p1742;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1742ATests extends AbstractOjTests {
    public CF1742ATests() {
        super("/p1742/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1742A.main(null);
        super.doAssertion();
    }
}
