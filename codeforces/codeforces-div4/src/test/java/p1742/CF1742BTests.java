package p1742;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1742BTests extends AbstractOjTests {
    public CF1742BTests() {
        super("/p1742/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1742B.main(null);
        super.doAssertion();
    }
}
