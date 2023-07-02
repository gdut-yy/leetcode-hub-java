package p587;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF587CTests extends AbstractOjTests {
    public CF587CTests() {
        super("/p587/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF587C.main(null);
        super.doAssertion();
    }
}