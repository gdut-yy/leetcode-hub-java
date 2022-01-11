package p1624;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1624ATests extends AbstractOjTests {
    public CF1624ATests() {
        super("/p1624/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1624A.main(null);
        super.doAssertion();
    }
}
