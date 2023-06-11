package p1555;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1555DTests extends AbstractOjTests {
    public CF1555DTests() {
        super("/p1555/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1555D.main(null);
        super.doAssertion();
    }
}