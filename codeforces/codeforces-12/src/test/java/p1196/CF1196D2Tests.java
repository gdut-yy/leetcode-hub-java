package p1196;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1196D2Tests extends AbstractOjTests {
    public CF1196D2Tests() {
        super("/p1196/D2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1196D2.main(null);
        super.doAssertion(OUTPUT1);
    }
}