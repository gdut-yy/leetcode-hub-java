package p2044;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2044HTests extends AbstractOjTests {
    public CF2044HTests() {
        super("/p2044/H/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2044H.main(null);
        super.doAssertion(OUTPUT1);
    }
}