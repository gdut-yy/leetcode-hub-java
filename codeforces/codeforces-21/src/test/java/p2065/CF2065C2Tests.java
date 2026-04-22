package p2065;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2065C2Tests extends AbstractOjTests {
    public CF2065C2Tests() {
        super("/p2065/C2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2065C2.main(null);
        super.doAssertion(OUTPUT1);
    }
}