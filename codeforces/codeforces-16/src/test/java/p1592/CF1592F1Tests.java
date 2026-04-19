package p1592;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1592F1Tests extends AbstractOjTests {
    public CF1592F1Tests() {
        super("/p1592/F1/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1592F1.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1592F1.main(null);
        super.doAssertion(OUTPUT2);
    }
}
