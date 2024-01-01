package p1680;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import p1690.CF1690A;

import java.io.IOException;

public class CF1680CTests extends AbstractOjTests {
    public CF1680CTests() {
        super("/p1680/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1680C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
