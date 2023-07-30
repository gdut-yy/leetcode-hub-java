package p292;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF292DTests extends AbstractOjTests {
    public CF292DTests() {
        super("/p292/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF292D.main(null);
        super.doAssertion();
    }
}