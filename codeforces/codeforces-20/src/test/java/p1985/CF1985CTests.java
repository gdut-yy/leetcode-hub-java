package p1985;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1985CTests extends AbstractOjTests {
    public CF1985CTests() {
        super("/p1985/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1985C.main(null);
        super.doAssertion(OUTPUT1);
    }
}