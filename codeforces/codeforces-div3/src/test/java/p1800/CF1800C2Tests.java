package p1800;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1800C2Tests extends AbstractOjTests {
    public CF1800C2Tests() {
        super("/p1800/C2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1800C2.main(null);
        super.doAssertion();
    }
}
