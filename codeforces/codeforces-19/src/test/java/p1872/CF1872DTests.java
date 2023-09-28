package p1872;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1872DTests extends AbstractOjTests {
    public CF1872DTests() {
        super("/p1872/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1872D.main(null);
        super.doAssertion();
    }
}