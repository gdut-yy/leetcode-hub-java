package p1800;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1800E2Tests extends AbstractOjTests {
    public CF1800E2Tests() {
        super("/p1800/E2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1800E2.main(null);
        super.doAssertion();
    }
}
