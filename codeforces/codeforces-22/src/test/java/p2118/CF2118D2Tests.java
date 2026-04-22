package p2118;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2118D2Tests extends AbstractOjTests {
    public CF2118D2Tests() {
        super("/p2118/D2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2118D2.main(null);
        super.doAssertion(OUTPUT1);
    }
}