package p1718;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1718A2Tests extends AbstractOjTests {
    public CF1718A2Tests() {
        super("/p1718/A2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1718A2.main(null);
        super.doAssertion();
    }
}