package p1834;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1834CTests extends AbstractOjTests {
    public CF1834CTests() {
        super("/p1834/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1834C.main(null);
        super.doAssertion();
    }
}