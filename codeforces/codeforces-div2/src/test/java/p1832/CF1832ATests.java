package p1832;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1832ATests extends AbstractOjTests {
    public CF1832ATests() {
        super("/p1832/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1832A.main(null);
        super.doAssertion();
    }
}