package p1442;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1442ATests extends AbstractOjTests {
    public CF1442ATests() {
        super("/p1442/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1442A.main(null);
        super.doAssertion();
    }
}