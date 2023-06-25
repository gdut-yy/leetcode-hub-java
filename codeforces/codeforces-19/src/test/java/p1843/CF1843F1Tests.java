package p1843;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1843F1Tests extends AbstractOjTests {
    public CF1843F1Tests() {
        super("/p1843/F1/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1843F1.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1843F1.main(null);
        super.doAssertion(OUTPUT2);
    }
}