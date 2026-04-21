package p1955;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1955CTests extends AbstractOjTests {
    public CF1955CTests() {
        super("/p1955/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1955C.main(null);
        super.doAssertion(OUTPUT1);
    }
}