package p1479;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1479B1Tests extends AbstractOjTests {
    public CF1479B1Tests() {
        super("/p1479/B1/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1479B1.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1479B1.main(null);
        super.doAssertion(OUTPUT2);
    }
}