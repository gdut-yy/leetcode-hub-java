package p1760;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1760CTests extends AbstractOjTests {
    public CF1760CTests() {
        super("/p1760/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1760C.main(null);
        super.doAssertion();
    }
}
