package p1537;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1537E2Tests extends AbstractOjTests {
    public CF1537E2Tests() {
        super("/p1537/E2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1537E2.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1537E2.main(null);
        super.doAssertion(OUTPUT2);
    }
}