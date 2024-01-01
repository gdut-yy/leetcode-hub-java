package p1678;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1678B2Tests extends AbstractOjTests {
    public CF1678B2Tests() {
        super("/p1678/B2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1678B2.main(null);
        super.doAssertion(OUTPUT1);
    }
}
