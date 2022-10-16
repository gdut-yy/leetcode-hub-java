package p1742;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1742DTests extends AbstractOjTests {
    public CF1742DTests() {
        super("/p1742/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1742D.main(null);
        super.doAssertion();
    }
}
