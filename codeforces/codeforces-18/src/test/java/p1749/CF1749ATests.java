package p1749;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1749ATests extends AbstractOjTests {
    public CF1749ATests() {
        super("/p1749/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1749A.main(null);
        super.doAssertion();
    }
}
