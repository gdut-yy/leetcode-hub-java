package p1593;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1593D1Tests extends AbstractOjTests {
    public CF1593D1Tests() {
        super("/p1593/D1/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1593D1.main(null);
        super.doAssertion();
    }
}
