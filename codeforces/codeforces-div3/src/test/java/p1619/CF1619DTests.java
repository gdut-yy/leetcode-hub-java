package p1619;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1619DTests extends AbstractOjTests {
    public CF1619DTests() {
        super("/p1619/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1619D.main(null);
        super.doAssertion();
    }
}
