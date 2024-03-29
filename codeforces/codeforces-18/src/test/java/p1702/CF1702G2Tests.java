package p1702;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1702G2Tests extends AbstractOjTests {
    public CF1702G2Tests() {
        super("/p1702/G2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1702G2.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1702G2.main(null);
        super.doAssertion(OUTPUT2);
    }
}
