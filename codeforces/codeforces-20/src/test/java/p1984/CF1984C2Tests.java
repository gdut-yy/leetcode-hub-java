package p1984;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1984C2Tests extends AbstractOjTests {
    public CF1984C2Tests() {
        super("/p1984/C2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1984C2.main(null);
        super.doAssertion(OUTPUT1);
    }
}