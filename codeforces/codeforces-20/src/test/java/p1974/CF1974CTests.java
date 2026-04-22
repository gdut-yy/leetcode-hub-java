package p1974;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1974CTests extends AbstractOjTests {
    public CF1974CTests() {
        super("/p1974/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1974C.main(null);
        super.doAssertion(OUTPUT1);
    }
}