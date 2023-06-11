package p1650;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1650ATests extends AbstractOjTests {
    public CF1650ATests() {
        super("/p1650/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1650A.main(null);
        super.doAssertion();
    }
}
