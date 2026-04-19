package p2039;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2039C2Tests extends AbstractOjTests {
    public CF2039C2Tests() {
        super("/p2039/C2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2039C2.main(null);
        super.doAssertion(OUTPUT1);
    }
}
